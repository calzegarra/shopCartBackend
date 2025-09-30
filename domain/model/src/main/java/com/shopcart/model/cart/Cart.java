package com.shopcart.model.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopcart.model.cartItem.CartItem;
import com.shopcart.model.user.User;
import com.shopcart.model.videogame.Videogame;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class Cart {
    private BigInteger id;
    private User user;
    private String cartState;
    private String total;
    private LocalDateTime createDate;
    private List<Videogame> detailsVideogames;
    @JsonIgnore
    private List<CartItem> listCartItems;
}
