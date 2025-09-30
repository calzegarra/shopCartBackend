package com.shopcart.jpa.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.math.BigInteger;

public interface UserDataRepository extends
        CrudRepository<UserData, BigInteger>, QueryByExampleExecutor<UserData> {
}
