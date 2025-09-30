package com.shopcart.jpa.role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import java.math.BigInteger;


public interface RoleDataRepository extends
        CrudRepository<RoleData, BigInteger>, QueryByExampleExecutor<RoleData> {
}
