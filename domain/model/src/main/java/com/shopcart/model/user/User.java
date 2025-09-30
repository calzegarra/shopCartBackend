package com.shopcart.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopcart.model.cart.Cart;
import com.shopcart.model.role.Role;
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
public class User {
    private BigInteger id;
    private String name;
    private String lastname;
    private String dni;
    private String address;
    private String email;
    private String username;
    private String password;
    private Role role;
    private byte[] avatar;
   @JsonIgnore
    private List<Cart> listCarts;
}
