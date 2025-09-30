package com.shopcart.jpa.cartitem;

import co.com.shopcart.jpa.AdapterOperations;
import com.shopcart.model.cartItem.CartItem;
import com.shopcart.model.cartItem.gateway.CartItemRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class CartItemRepositoryAdapter extends AdapterOperations<CartItem, CartItemData, BigInteger, CartItemDataRepository>
        implements CartItemRepository {

    @Autowired
    public CartItemRepositoryAdapter(CartItemDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, CartItem.CartItemBuilder.class).build());
    }
}
