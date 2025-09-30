package com.shopcart.jpa.role;

import com.shopcart.jpa.user.UserData;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.math.BigInteger;
import java.util.List;

@Data
@Entity
@Table(name = "tb_rol")
@NoArgsConstructor
public class RoleData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private BigInteger id;

    @Column(name = "descripcion", length = 45, nullable = false)
    private String description;

    @Transient
    @OneToMany(mappedBy = "role")
    private List<UserData> listUsers;
}
