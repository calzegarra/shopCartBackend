package com.shopcart.model.productitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DtoProductItem {
    private BigInteger videogameId;
    private Integer amount;
    private BigDecimal unitPrice;
    private BigDecimal unitDiscount;
    private BigDecimal subtotal;
}