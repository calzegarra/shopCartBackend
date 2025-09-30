package com.shopcart.model.common.exception;

public class NotFoundException extends ShoppingCartException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(404, message);
    }
}