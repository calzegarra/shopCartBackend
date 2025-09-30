package com.shopcart.jpa.videogamepromo;

import com.shopcart.jpa.promo.PromoData;
import com.shopcart.jpa.videogame.VideogameData;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;


@Data
@Entity
@Table(name = "tb_videojuegos_promo")
@NoArgsConstructor
public class VideogamePromoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_videojuegos_promo",  nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_videojuegos",  nullable = false)
    private VideogameData videogame;

    @ManyToOne
    @JoinColumn(name = "id_promocion",  nullable = false)
    private PromoData promotion;
}
