package com.shopcart.jpa.videogamecategory;

import co.com.shopcart.jpa.AdapterOperations;
import com.shopcart.model.videogamecategory.VideogameCategory;
import com.shopcart.model.videogamecategory.gateway.VideogameCategoryRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VideogameCategoryRepositoryAdapter extends
        AdapterOperations<VideogameCategory, VideogameCategoryData, Integer, VideogameCategoryDataRepository>
        implements VideogameCategoryRepository {

    @Autowired
    public VideogameCategoryRepositoryAdapter(VideogameCategoryDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper,  d -> mapper.mapBuilder(d, VideogameCategory.VideogameCategoryBuilder.class).build());
    }
}
