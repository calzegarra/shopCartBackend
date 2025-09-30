package com.shopcart.jpa.user;

import co.com.shopcart.jpa.AdapterOperations;
import com.shopcart.jpa.util.ConverterMapper;
import com.shopcart.model.user.User;
import com.shopcart.model.user.gateway.UserRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class UserRepositoryAdapter extends
        AdapterOperations<User, UserData, BigInteger, UserDataRepository> implements UserRepository {

    @Autowired
    public UserRepositoryAdapter(UserDataRepository repository, ObjectMapper mapper,
                                 ConverterMapper converterMapper) {
        super(repository, mapper,  converterMapper::toEntityUser);
    }
}
