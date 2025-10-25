package com.shopcart.model.user.gateway;

import com.shopcart.model.user.User;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    User findById(BigInteger id);
    List<User> findByExample(User user);
    List<User> findAll();
    Optional<User> findByUsername(String username);
}
