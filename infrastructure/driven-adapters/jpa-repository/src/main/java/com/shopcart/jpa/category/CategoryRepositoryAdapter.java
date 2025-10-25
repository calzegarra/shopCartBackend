package com.shopcart.jpa.category;

import com.shopcart.generic.AdapterOperations;
import com.shopcart.model.category.Category;
import com.shopcart.model.category.gateway.CategoryRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;


@Repository
public class CategoryRepositoryAdapter extends AdapterOperations <Category, CategoryData, BigInteger,
        CategoryDataRepository> implements CategoryRepository {

    @Autowired
    public CategoryRepositoryAdapter(CategoryDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Category.CategoryBuilder.class).build());
    }
}
