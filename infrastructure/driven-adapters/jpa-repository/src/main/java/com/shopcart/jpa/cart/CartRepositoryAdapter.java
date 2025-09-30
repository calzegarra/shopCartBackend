package com.shopcart.jpa.cart;

import com.shopcart.jpa.util.ConverterMapper;
import com.shopcart.model.cart.Cart;
import com.shopcart.model.cart.gateway.CartRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.com.shopcart.jpa.AdapterOperations;
import java.math.BigInteger;

@Repository
public class CartRepositoryAdapter extends AdapterOperations <Cart, CartData, BigInteger, CartDataRepository>
        implements CartRepository {

    @Autowired
    public CartRepositoryAdapter(CartDataRepository repository, ObjectMapper mapper, ConverterMapper converterMapper) {
        super(repository, mapper, converterMapper::toEntityCart);
    }
}
