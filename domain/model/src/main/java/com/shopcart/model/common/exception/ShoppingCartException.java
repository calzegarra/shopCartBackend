package com.shopcart.model.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ShoppingCartException extends Exception{
    private static final long serialVersionUID = 1L;
    private final int responseCode;

    public ShoppingCartException(int responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }
}
