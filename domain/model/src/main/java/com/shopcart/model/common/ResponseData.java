package com.shopcart.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponseData {

    private Object data;
    private Boolean status;
    private String message;
    private  int code;
}