package com.shopcart.jpa.console;

import co.com.shopcart.jpa.AdapterOperations;
import com.shopcart.model.console.Console;
import com.shopcart.model.console.gateway.ConsoleRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


@Repository
public class ConsoleRepositoryAdapter extends AdapterOperations<Console, ConsoleData, BigInteger,
        ConsoleDataRepository> implements ConsoleRepository {

    @Autowired
    public ConsoleRepositoryAdapter(ConsoleDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Console.ConsoleBuilder.class).build());
    }
}
