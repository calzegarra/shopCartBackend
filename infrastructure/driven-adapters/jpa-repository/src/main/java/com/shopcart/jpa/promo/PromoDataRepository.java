package com.shopcart.jpa.promo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.math.BigInteger;

public interface PromoDataRepository extends CrudRepository<PromoData, BigInteger>,
        QueryByExampleExecutor<PromoData> {
}
