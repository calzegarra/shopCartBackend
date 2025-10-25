package com.shopcart.model.common.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DtoUsersList {
    private BigInteger id;
    private String name;
    private String lastname;
    private String dni;
    private String email;
    private String role;
}
