package com.shopcart.api.user;

import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.exception.ShoppingCartException;
import com.shopcart.model.user.User;
import com.shopcart.usecase.user.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserService {
    private final UserUseCase useCase;
    private ResponseData responseData;

    @PostMapping(path = "/create")
    public ResponseData createUser(@Validated @RequestBody User data)
            throws ShoppingCartException {
        responseData = useCase.createUser(data);
        if (responseData.getStatus()) {
            responseData.setCode(HttpStatus.CREATED.value());
        } else {
            responseData.setCode(HttpStatus.BAD_REQUEST.value());
        }
        return responseData;
    }

    @PostMapping(path = "/update")
    public ResponseData updateUser(@Validated @RequestBody User data)
            throws ShoppingCartException {
        responseData = useCase.updateUser(data);
        if (responseData.getStatus()) {
            responseData.setCode(HttpStatus.CREATED.value());
        } else {
            responseData.setCode(HttpStatus.BAD_REQUEST.value());
        }
        return responseData;
    }

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


    @GetMapping(path = "/findAllEmployers")
    public ResponseData findAllEmployers(){
        responseData = useCase.findAllEmployers();
        responseData.setCode(HttpStatus.CREATED.value());
        return responseData;
    }
}
