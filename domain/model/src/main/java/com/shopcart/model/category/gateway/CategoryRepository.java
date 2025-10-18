package com.shopcart.model.category.gateway;

import com.shopcart.model.category.Category;

import java.math.BigInteger;
import java.util.List;

public interface CategoryRepository {
    Category save(Category category);
    Category findById(BigInteger id);
    List<Category> findByExample(Category console);
    List<Category> findAll();
}