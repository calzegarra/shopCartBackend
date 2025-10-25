package com.shopcart.usecase.user;

import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.auth.Auth;
import com.shopcart.model.common.exception.ShoppingCartException;
import com.shopcart.model.user.User;
import com.shopcart.model.user.gateway.UserRepository;
import com.shopcart.usecase.util.ConstantsMessages;
import lombok.RequiredArgsConstructor;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class UserUseCase {
    private final UserRepository userRepository;
    private ResponseData responseData;
    private User userNow;

    public ResponseData createUser(User user)
            throws ShoppingCartException {
        responseData = new ResponseData();
        if (!validateObject(user)) {
            responseData.setData(userRepository.save(user));
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            throw new ShoppingCartException(400, ConstantsMessages.RECORD_EMPTY);
        }
        return responseData;
    }

    private boolean validateObject(User user) {
        return Stream.of(
                        user.getName(),
                        user.getLastname(),
                        user.getDni(),
                        user.getEmail(),
                        user.getUsername()
                ).anyMatch(this::validateEmpty);
    }

    private boolean validateEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public ResponseData updateUser(User user)
            throws ShoppingCartException {
        responseData = new ResponseData();
        userNow = new User();
        userNow = userRepository.findById(user.getId());
        if (!validateObject(userNow)) {
            changeAttributes(user);
            responseData.setData(userRepository.save(userNow));
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            throw new ShoppingCartException(400, ConstantsMessages.RECORD_EMPTY);
        }
        return responseData;
    }

    private void changeAttributes(User user) {
        userNow.setName(user.getName());
        userNow.setLastname(user.getLastname());
        userNow.setDni(user.getDni());
        userNow.setAddress(user.getAddress());
        userNow.setEmail(user.getEmail());
        userNow.setUsername(user.getUsername());
        userNow.setPassword(user.getPassword());
        userNow.setRole(user.getRole());
        userNow.setAvatar(user.getAvatar());
    }

    public ResponseData findById(BigInteger id) {
        responseData = new ResponseData();
        User user = userRepository.findById(id);
        if (user != null) {
            responseData.setData(user);
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            responseData.setMessage(ConstantsMessages.NOT_RECORD_EXIST);
        }
        return responseData;
    }

    public ResponseData findAllEmployers(){
        responseData = new ResponseData();
        List<User> employers = userRepository.findAll().stream().filter(user -> user.getRole() != null &&
                        (user.getRole().getId().equals(BigInteger.ONE) ||
                                user.getRole().getId().equals(BigInteger.valueOf(2)))).collect(Collectors.toList());
        responseData.setStatus(Boolean.TRUE);
        if (!employers.isEmpty()) {
            responseData.setData(employers);
            responseData.setMessage(ConstantsMessages.LIST_RECORD_SUCCESS);
        }else {
            responseData.setMessage(ConstantsMessages.LIST_RECORD_EMPTY);
        }
        return responseData;
    }

    public ResponseData findByUser(Auth data) {
        responseData = new ResponseData();
        User obj = new User();
        obj.setUsername(data.getUsername());
        obj.setPassword(data.getPassword());
        userNow = new User();
        userNow = userRepository.findByExample(obj).get(0);
        if (userNow != null) {
            responseData.setData(userNow);
            responseData.setMessage(ConstantsMessages.LIST_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            responseData.setMessage(ConstantsMessages.LIST_RECORD_EMPTY);
        }
        return responseData;
    }

}
