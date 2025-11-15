package com.shopcart.api.promo;

import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.exception.ShoppingCartException;
import com.shopcart.model.promo.Promotion;
import com.shopcart.usecase.promo.PromoUseCase;
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
@RequestMapping(value = "/api/promo", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PromoService {
    private final PromoUseCase useCase;
    private ResponseData responseData;

    @PostMapping(path = "/create")
    public ResponseData createPromo(@Validated @RequestBody Promotion data)
            throws ShoppingCartException {
        responseData = useCase.createPromo(data);
        if (responseData.getStatus()) {
            responseData.setCode(HttpStatus.CREATED.value());
        } else {
            responseData.setCode(HttpStatus.BAD_REQUEST.value());
        }
        return responseData;
    }

    @PostMapping(path = "/update")
    public ResponseData updatePromo(@Validated @RequestBody Promotion data)
            throws ShoppingCartException {
        responseData = useCase.updatePromo(data);
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


    @GetMapping(path = "/findAll")
    public ResponseData findAll(){
        responseData = useCase.findAll();
        responseData.setCode(HttpStatus.CREATED.value());
        return responseData;
    }
}
