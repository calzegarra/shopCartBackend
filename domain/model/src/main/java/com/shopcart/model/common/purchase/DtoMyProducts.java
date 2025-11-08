package com.shopcart.model.common.purchase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DtoMyProducts {
    private String title;
    private Integer amount;
    private BigDecimal unitPrice;
    private BigDecimal unitDiscount;
    private BigDecimal subtotal;
    private byte[] mini;
}
