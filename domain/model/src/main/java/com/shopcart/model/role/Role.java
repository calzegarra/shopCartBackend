package com.shopcart.model.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopcart.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.math.BigInteger;
import java.util.List;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class Role {
    private BigInteger id;
    private String description;
    @JsonIgnore
    private List<User> listUsers;
}
