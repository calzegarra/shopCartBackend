package com.shopcart.model.cartItem.gateway;

import com.shopcart.model.cartItem.CartItem;

import java.math.BigInteger;
import java.util.List;

public interface CartItemRepository {
    CartItem save(CartItem item);
    CartItem findById(BigInteger id);
    List<CartItem> findByExample(CartItem console);
}
