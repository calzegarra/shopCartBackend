package com.shopcart.jpa.videogamepromo;

import com.shopcart.generic.AdapterOperations;
import com.shopcart.model.videogamepromo.VideogamePromo;
import com.shopcart.model.videogamepromo.gateway.VideogamePromoRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class VideogamePromoRepositoryAdapter extends
        AdapterOperations<VideogamePromo, VideogamePromoData, Integer, VideogamePromoDataRepository>
        implements VideogamePromoRepository {

    @Autowired
    public VideogamePromoRepositoryAdapter(VideogamePromoDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper,  d -> mapper.mapBuilder(d, VideogamePromo.VideogamePromoBuilder.class).build());
    }
}
