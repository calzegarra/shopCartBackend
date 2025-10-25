package com.shopcart.model.console.gateway;

import com.shopcart.model.console.Console;

import java.math.BigInteger;
import java.util.List;

public interface ConsoleRepository {
    Console save(Console console);
    Console findById(BigInteger id);
    List<Console> findByExample(Console console);
    List<Console> findAll();
}
