package com.shopcart.jpa.user;

import com.shopcart.jpa.cart.CartData;
import com.shopcart.jpa.role.RoleData;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.persistence.ManyToOne;
import javax.persistence.Lob;
import javax.persistence.JoinColumn;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.math.BigInteger;
import java.util.List;

@Data
@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private BigInteger id;

    @Column(name = "nombres", length = 45, nullable = false)
    private String name;

    @Column(name = "apellidos", length = 45, nullable = false)
    private String lastname;

    @Column(name = "dni", length = 45, nullable = false)
    private String dni;

    @Column(name = "direccion", length = 45, nullable = false)
    private String address;

    @Column(name = "correo", length = 45, nullable = false)
    private String email;

    @Column(name = "usu_nom", length = 45, nullable = false)
    private String username;

    @Column(name = "clave", length = 45, nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_rol",  nullable = false)
    private RoleData role;

    @Lob
    @Column(name = "avatar", nullable = true)
    private byte[] avatar;

    @Transient
    @OneToMany(mappedBy = "user")
    private List<CartData> listCarts;
}
