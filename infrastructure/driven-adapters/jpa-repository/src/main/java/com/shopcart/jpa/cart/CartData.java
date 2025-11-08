package com.shopcart.jpa.cart;

import com.shopcart.jpa.cartitem.CartItemData;
import com.shopcart.jpa.user.UserData;
import com.shopcart.jpa.videogame.VideogameData;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.GenerationType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "tb_carrito")
@NoArgsConstructor
public class CartData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name = "id_usuario",  nullable = false)
    private UserData user;

    @Column(name = "estado_carrito", length = 50, nullable = false)
    private String cartState;

    @Column(name = "total_estimado", nullable = true)
    private BigDecimal total;

    @Column(name = "fecha_registro")
    private LocalDateTime createDate;

    @ManyToMany
    @JoinTable(name = "tb_carrito_item", joinColumns = @JoinColumn(name = "id_carrito"),
            inverseJoinColumns = @JoinColumn(name = "id_videojuegos"))
    private List<VideogameData> detailsVideogames;

    @Transient
    @OneToMany(mappedBy = "cart")
    private List<CartItemData> listCartItems;
}
