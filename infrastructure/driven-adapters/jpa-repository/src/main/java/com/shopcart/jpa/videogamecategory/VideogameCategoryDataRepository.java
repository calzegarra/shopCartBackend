package com.shopcart.jpa.videogamecategory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface VideogameCategoryDataRepository extends
        CrudRepository<VideogameCategoryData, Integer>, QueryByExampleExecutor<VideogameCategoryData> {
}
