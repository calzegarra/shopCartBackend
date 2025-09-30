package com.shopcart.jpa.videogamecategory;

import com.shopcart.jpa.category.CategoryData;
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
@Table(name = "tb_videojuegos_categoria")
@NoArgsConstructor
public class VideogameCategoryData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_videojuegos_categoria",  nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_videojuegos",  nullable = false)
    private VideogameData videogame;

    @ManyToOne
    @JoinColumn(name = "id_categoria",  nullable = false)
    private CategoryData category;
}
