package com.shopcart.model.shop;

import com.shopcart.model.detailShop.DetailShop;
import com.shopcart.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class Shop {
    private BigInteger id;
    private User user;
    //private LocalDateTime fechaEntrega;
    //private LocalDateTime fechaEnvio;
    private LocalDateTime purchaseDate;
    private BigDecimal total;
    private List<DetailShop> detail;
}
