package com.shopcart.jpa.videogamepromo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface VideogamePromoDataRepository extends
        CrudRepository<VideogamePromoData, Integer>, QueryByExampleExecutor<VideogamePromoData> {
}
