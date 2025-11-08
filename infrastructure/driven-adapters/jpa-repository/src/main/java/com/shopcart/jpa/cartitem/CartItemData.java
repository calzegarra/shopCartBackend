package com.shopcart.jpa.cartitem;

import com.shopcart.jpa.cart.CartData;
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
import javax.persistence.GenerationType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_carrito_item")
@NoArgsConstructor
public class CartItemData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name = "id_carrito",  nullable = false)
    private CartData cart;

    @ManyToOne
    @JoinColumn(name = "id_videojuegos",  nullable = false)
    private VideogameData videogame;

    @Column(name = "cantidad")
    private Integer amount;

    @Column(name = "precio_unitario")
    private BigDecimal unitPrice;

    @Column(name = "descuento_unitario")
    private BigDecimal unitDiscount;

    @Column(name = "subtotal")
    private BigDecimal subtotal;

    @Column(name = "fecha_registro")
    private LocalDateTime createDate;

    @Column(name = "puntaje")
    private Integer scorePoint;

    @Column(name = "comentario", length = 5000, nullable = false)
    private String comment;

    @Column(name = "fecha_comentario")
    private LocalDateTime dateComment;


}
