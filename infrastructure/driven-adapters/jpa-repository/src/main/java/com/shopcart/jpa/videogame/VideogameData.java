package com.shopcart.jpa.videogame;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopcart.jpa.cartitem.CartItemData;
import com.shopcart.jpa.category.CategoryData;
import com.shopcart.jpa.console.ConsoleData;
import com.shopcart.jpa.promo.PromoData;
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
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.GenerationType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;


@Data
@Entity
@Table(name = "tb_videojuegos")
@NoArgsConstructor
public class VideogameData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_videojuegos")
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name = "id_consola",  nullable = false)
    private ConsoleData console;

    @Column(name = "titulo", length = 500, nullable = false)
    private String title;

    @Column(name = "descipcion", length = 1000, nullable = false)
    private String description;

    @Column(name = "tiene_desc", nullable = false)
    private Boolean hasDiscount;

    @Column(name = "unidad_existencia", nullable = false)
    private Integer stock;

    @Column(name = "unidad_precio",nullable = false)
    private BigDecimal price;

    @Column(name = "estado", length = 100,nullable = false)
    private String state;

    @Lob
    @Column(name = "imagen",  nullable = true)
    private byte[] image;

    @Lob
    @Column(name = "imagen2",nullable = true)
    private byte[] image2;

    @Lob
    @Column(name = "imagen3", nullable = true)
    private byte[] image3;

    @Lob
    @Column(name = "mini_imagen", nullable = true)
    private byte[] mini;

    @Lob
    @Column(name = "archivo", nullable = true)
    private byte[] file;

    @ManyToMany
    @JoinTable(name = "tb_videojuegos_promo", joinColumns = @JoinColumn(name = "id_videojuegos"),
            inverseJoinColumns = @JoinColumn(name = "id_promocion"))
    private List<PromoData> detailsPromo;

    @ManyToMany
    @JoinTable(name = "tb_videojuegos_categoria", joinColumns = @JoinColumn(name = "id_videojuegos"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private List<CategoryData> detailsCategories;

    @Transient
    private List<CartItemData> listCartItems;


}
