package com.shopcart.api.cart;

import com.shopcart.model.cart.Cart;
import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.exception.ShoppingCartException;
import com.shopcart.model.productitem.DtoBuyItems;
import com.shopcart.usecase.cart.CartUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/api/cart", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CartService {
    private final CartUseCase useCase;
    private ResponseData responseData;

    @PreAuthorize("hasRole('CLIENTE')")
    @PostMapping(path = "/buyProducts")
    public ResponseData buyProducts(@Validated @RequestBody DtoBuyItems item)
            throws ShoppingCartException {
         responseData = useCase.buyProducts(item);
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


    @GetMapping(path = "/findMyPurchases/{userId}")
    public ResponseData findMyPurchases(@PathVariable BigInteger userId){
        responseData = useCase.findAllMyCarts(userId);
        responseData.setCode(HttpStatus.CREATED.value());
        return responseData;
    }
}
