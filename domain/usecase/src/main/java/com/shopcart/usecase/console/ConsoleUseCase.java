package com.shopcart.usecase.console;

import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.exception.ShoppingCartException;
import com.shopcart.model.console.Console;
import com.shopcart.model.console.gateway.ConsoleRepository;
import com.shopcart.usecase.util.ConstantsMessages;
import lombok.RequiredArgsConstructor;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class ConsoleUseCase {
    private final ConsoleRepository consoleRepository;
    private ResponseData responseData;
    private Console consoleNow;

    public ResponseData createConsole(Console console) {
        responseData = new ResponseData();
        if (!validateEmpty(console.getDescription())) {
            console.setCreateDate(LocalDateTime.now());
            console.setState(Boolean.TRUE);
            console.setCreateBy("userEmp");
            responseData.setData(consoleRepository.save(console));
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            responseData.setMessage(ConstantsMessages.RECORD_EMPTY);
        }
        return responseData;
    }

    private boolean validateEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public ResponseData updateConsole(Console console)
            throws ShoppingCartException {
        responseData = new ResponseData();
        consoleNow = new Console();
        consoleNow = consoleRepository.findById(console.getId());
        if (consoleNow != null) {
            changeAttributes(console);
            responseData.setData(consoleRepository.save(consoleNow));
            responseData.setMessage(ConstantsMessages.UPDATE_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            throw new ShoppingCartException(400, ConstantsMessages.UPDATE_RECORD_FAILED);
        }
        return responseData;
    }

    private void changeAttributes(Console console) {
        consoleNow.setDescription(console.getDescription());
        consoleNow.setState(console.getState());
    }

    public ResponseData findById(BigInteger id) {
        responseData = new ResponseData();
        Console console = consoleRepository.findById(id);
        if (console != null) {
            responseData.setData(console);
            responseData.setMessage(ConstantsMessages.LIST_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            responseData.setMessage(ConstantsMessages.NOT_RECORD_EXIST);
        }
        return responseData;
    }

    public ResponseData findAll() {
        responseData = new ResponseData();
        List<Console> list = consoleRepository.findAll();
        responseData.setStatus(Boolean.TRUE);
        if (!list.isEmpty()) {
            responseData.setData(list);
            responseData.setMessage(ConstantsMessages.LIST_RECORD_SUCCESS);
        }else {
            responseData.setMessage(ConstantsMessages.NOT_RECORD_EXIST);
        }
        return responseData;
    }
}
