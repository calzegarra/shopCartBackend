package com.shopcart.jpa.console;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import java.math.BigInteger;

public interface ConsoleDataRepository extends CrudRepository<ConsoleData, BigInteger>,
        QueryByExampleExecutor<ConsoleData> {
}
