package com.shopcart.model.promo.gateway;

import com.shopcart.model.promo.Promotion;
import java.math.BigInteger;
import java.util.List;

public interface PromoRepository {
    Promotion save(Promotion promo);
    Promotion findById(BigInteger id);
    List<Promotion> findByExample(Promotion promo);
    List<Promotion> findAll();
}