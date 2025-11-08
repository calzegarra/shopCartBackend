package com.shopcart.model.common.purchase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DtoPurchases {
    private String user;
    private List<DtoMyProducts> detailItems;
    private BigDecimal total;
    private LocalDateTime createDate;
}
