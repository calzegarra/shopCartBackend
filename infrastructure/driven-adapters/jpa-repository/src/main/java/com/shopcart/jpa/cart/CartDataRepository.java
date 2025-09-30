package com.shopcart.jpa.cart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.math.BigInteger;

public interface CartDataRepository extends CrudRepository<CartData, BigInteger>,
        QueryByExampleExecutor<CartData> {
}
