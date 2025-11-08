package com.shopcart.model.cartItem;

import com.shopcart.model.cart.Cart;
import com.shopcart.model.videogame.Videogame;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class CartItem {
    private BigInteger id;
    private Cart cart;
    private Videogame videogame;
    private Integer amount;
    private BigDecimal unitPrice;
    private BigDecimal unitDiscount;
    private BigDecimal subtotal;
    private LocalDateTime createDate;
    private Integer scorePoint;
    private String comment;
    private LocalDateTime dateComment;
}
