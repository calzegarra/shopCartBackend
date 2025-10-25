package com.shopcart.api.cart;

import com.shopcart.model.cart.Cart;
import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.exception.ShoppingCartException;
import com.shopcart.usecase.cart.CartUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/api/cart", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CartService {
    private final CartUseCase useCase;
    private ResponseData responseData;

    @PostMapping(path = "/create")
    public ResponseData createCart(@Validated @RequestBody Cart data)
            throws ShoppingCartException {
        // responseData = useCase.createUser(data);
        if (responseData.getStatus()) {
            responseData.setCode(HttpStatus.CREATED.value());
        } else {
            responseData.setCode(HttpStatus.BAD_REQUEST.value());
        }
        return responseData;
    }

    @PostMapping(path = "/update")
    public ResponseData updateCart(@Validated @RequestBody Cart data)
            throws ShoppingCartException {
        //responseData = useCase.updateUser(data);
        if (responseData.getStatus()) {
            responseData.setCode(HttpStatus.CREATED.value());
        } else {
            responseData.setCode(HttpStatus.BAD_REQUEST.value());
        }
        return responseData;
    }

    @GetMapping(path = "/findById/{id}")
    public ResponseData findById(@PathVariable BigInteger id){
        // responseData = useCase.findById(id);
        if (responseData.getStatus()) {
            responseData.setCode(HttpStatus.CREATED.value());
        } else {
            responseData.setCode(HttpStatus.BAD_REQUEST.value());
        }
        return responseData;
    }


    @GetMapping(path = "/findAll")
    public ResponseData findAll(){
        // responseData = useCase.findAllEmployers();
        responseData.setCode(HttpStatus.CREATED.value());
        return responseData;
    }
}
