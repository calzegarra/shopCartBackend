package com.shopcart.model.role.gateway;

    import com.shopcart.model.role.Role;

import java.math.BigInteger;
import java.util.List;

public interface RoleRepository {
    Role save(Role role);
    Role findById(BigInteger id);
    List<Role> findAll();
}
