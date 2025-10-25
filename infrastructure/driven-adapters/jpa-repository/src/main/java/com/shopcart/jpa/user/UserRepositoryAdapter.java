package com.shopcart.jpa.user;

import com.shopcart.generic.AdapterOperations;
import com.shopcart.jpa.util.ConverterMapper;
import com.shopcart.model.user.User;
import com.shopcart.model.user.gateway.UserRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryAdapter extends
        AdapterOperations<User, UserData, BigInteger, UserDataRepository> implements UserRepository {

    @Autowired
    public UserRepositoryAdapter(UserDataRepository repository, ObjectMapper mapper,
                                 ConverterMapper converterMapper) {
        super(repository, mapper,  converterMapper::toEntityUser);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        User object = new User();
        object.setUsername(username);
        List<User> result = findByExample(object);
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }
}
