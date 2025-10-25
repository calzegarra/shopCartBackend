package com.shopcart.model.cart.gateway;

import com.shopcart.model.cart.Cart;
import java.math.BigInteger;
import java.util.List;

public interface CartRepository {
    Cart save(Cart cart);
    Cart findById(BigInteger id);
    List<Cart> findByExample(Cart cart);
    List<Cart> findAll();
}
