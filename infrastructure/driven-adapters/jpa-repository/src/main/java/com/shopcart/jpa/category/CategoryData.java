package com.shopcart.jpa.category;


import com.shopcart.jpa.videogame.VideogameData;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "tb_categoria")
@NoArgsConstructor
public class CategoryData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private BigInteger id;

    @Column(name = "descripcion", length = 200, nullable = false)
    private String description;

    @Column(name = "estado")
    private Boolean state;

    @Column(name = "fecha_registro")
    private LocalDateTime createDate;

    @Column(name = "creado_por", length = 100, nullable = false)
    private String createBy;

    @Transient
    @ManyToMany(mappedBy = "detailsCategories")
    private List<VideogameData> listVideogames;
}
