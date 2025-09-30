package com.shopcart.model.common.exception;



public class RequiredFieldException extends ShoppingCartException {
    private static final long serialVersionUID = 1L;

    public RequiredFieldException(String message) {
        super(400,message);
    }
}
