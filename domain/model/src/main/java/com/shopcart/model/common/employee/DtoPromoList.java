package com.shopcart.model.common.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DtoPromoList {
    private BigInteger id;
    private String description;
    private Double discount;
    private Boolean state;
    private LocalDateTime createDate;
}
