package com.shopcart.model.detailShop;

import com.shopcart.model.shop.Shop;
import com.shopcart.model.videogame.Videogame;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class DetailShop {
    private BigInteger id;
    private Shop shop;
    private Videogame videogame;
    private BigDecimal price;
    private Integer amount;
}
