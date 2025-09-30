package com.shopcart.jpa.category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import java.math.BigInteger;

public interface CategoryDataRepository extends CrudRepository<CategoryData, BigInteger>,
        QueryByExampleExecutor<CategoryData> {
}

