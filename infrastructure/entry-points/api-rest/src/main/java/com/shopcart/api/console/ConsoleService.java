package com.shopcart.api.console;

import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.exception.ShoppingCartException;
import com.shopcart.model.console.Console;
import com.shopcart.usecase.console.ConsoleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.math.BigInteger;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/api/console", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ConsoleService {
    private final ConsoleUseCase useCase;
    private ResponseData responseData;
    @PreAuthorize("hasRole('EMPLEADO')")
    @PostMapping(path = "/create")
    public ResponseData createConsole(@Validated @RequestBody Console data)
            throws ShoppingCartException {
        responseData = useCase.createConsole(data);
        if (responseData.getStatus()) {
            responseData.setCode(HttpStatus.CREATED.value());
        } else {
            responseData.setCode(HttpStatus.BAD_REQUEST.value());
        }
        return responseData;
    }
    @PreAuthorize("hasRole('EMPLEADO')")
    @PostMapping(path = "/update")
    public ResponseData updateConsole(@Validated @RequestBody Console data)
            throws ShoppingCartException {
        responseData = useCase.updateConsole(data);
        if (responseData.getStatus()) {
            responseData.setCode(HttpStatus.CREATED.value());
        } else {
            responseData.setCode(HttpStatus.BAD_REQUEST.value());
        }
        return responseData;
    }

    @PreAuthorize("hasRole('EMPLEADO')")
    @GetMapping(path = "/findById/{id}")
    public ResponseData findById(@PathVariable BigInteger id){
        responseData = useCase.findById(id);
        if (responseData.getStatus()) {
            responseData.setCode(HttpStatus.CREATED.value());
        } else {
            responseData.setCode(HttpStatus.BAD_REQUEST.value());
        }
        return responseData;
    }
    @PreAuthorize("hasRole('EMPLEADO')")
    @GetMapping(path = "/findAll")
    public ResponseData findAll(){
        responseData = useCase.findAll();
        responseData.setCode(HttpStatus.CREATED.value());
        return responseData;
    }
}
