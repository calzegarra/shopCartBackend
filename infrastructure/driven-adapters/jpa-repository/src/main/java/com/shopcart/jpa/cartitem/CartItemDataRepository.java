package com.shopcart.jpa.cartitem;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import java.math.BigInteger;

public interface CartItemDataRepository extends CrudRepository<CartItemData, BigInteger>,
        QueryByExampleExecutor<CartItemData> {
}
