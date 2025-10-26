package com.shopcart.model.videogame;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopcart.model.cartItem.CartItem;
import com.shopcart.model.category.Category;
import com.shopcart.model.console.Console;
import com.shopcart.model.promo.Promotion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class Videogame {
    private BigInteger id;
    private Console console;
    private String title;
    private String description;
    private Boolean hasDiscount;
    private Integer stock;
    private BigDecimal price;
    private String state;
    private byte[] image;
    private byte[] image2;
    private byte[] image3;
    private byte[] mini;
    private List<Promotion> detailsPromo;
    private List<Category> detailsCategories;

    @JsonIgnore
    private List<CartItem> listCartItems;
}
