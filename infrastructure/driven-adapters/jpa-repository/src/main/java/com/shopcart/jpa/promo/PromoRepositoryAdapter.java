package com.shopcart.jpa.promo;

import com.shopcart.generic.AdapterOperations;
import com.shopcart.model.promo.Promotion;
import com.shopcart.model.promo.gateway.PromoRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class PromoRepositoryAdapter extends AdapterOperations<Promotion, PromoData, BigInteger,
        PromoDataRepository> implements PromoRepository {

    @Autowired
    public PromoRepositoryAdapter(PromoDataRepository repository, ObjectMapper mapper) {
         super(repository, mapper, d -> mapper.mapBuilder(d, Promotion.PromotionBuilder.class).build());
    }
}
