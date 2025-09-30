package com.shopcart.jpa.role;

import co.com.shopcart.jpa.AdapterOperations;
import com.shopcart.model.role.Role;
import com.shopcart.model.role.gateway.RoleRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class RoleRepositoryAdapter extends
        AdapterOperations<Role, RoleData, BigInteger, RoleDataRepository> implements RoleRepository {

    @Autowired
    public RoleRepositoryAdapter(RoleDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Role.RoleBuilder.class).build());
    }

}
