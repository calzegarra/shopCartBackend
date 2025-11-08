package com.shopcart.model.cart.gateway;

import com.shopcart.model.cart.Cart;
import com.shopcart.model.common.purchase.DtoMyCart;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface CartRepository {
    Cart save(Cart cart);
    Cart findById(BigInteger id);
    List<Cart> findByExample(Cart cart);
    void updateTotalCart(BigDecimal total, Integer id);
    List<DtoMyCart> findMyCarts(Integer userId);
}
