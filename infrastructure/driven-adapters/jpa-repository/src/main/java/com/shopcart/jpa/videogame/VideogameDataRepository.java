package com.shopcart.jpa.videogame;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.math.BigInteger;

public interface VideogameDataRepository extends
        CrudRepository<VideogameData, BigInteger>, QueryByExampleExecutor<VideogameData> {
}
