package com.shopcart.model.common.employee;

import com.shopcart.model.console.Console;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DtoVideogameList {
    private BigInteger id;
    private Console console;
    private String title;
    private BigDecimal price;
    private String state;
}
