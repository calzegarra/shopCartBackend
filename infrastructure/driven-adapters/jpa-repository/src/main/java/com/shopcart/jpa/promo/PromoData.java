package com.shopcart.jpa.promo;

import com.shopcart.jpa.videogame.VideogameData;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Lob;
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
@Table(name = "tb_promocion")
@NoArgsConstructor
public class PromoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_promocion")
    private BigInteger id;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String description;

    @Column(name = "descuento")
    private Double discount;

    @Column(name = "fecha_incio")
    private LocalDateTime startDate;

    @Column(name = "fecha_fin")
    private LocalDateTime endDate;

    @Column(name = "estado")
    private Boolean state;

    @Lob
    @Column(name = "imagen_promo")
    private byte[] imagePromo;

    @Column(name = "fecha_registro")
    private LocalDateTime createDate;

    @Column(name = "creado_por", length = 100, nullable = false)
    private String createBy;

    @Transient
    @ManyToMany(mappedBy = "detailsPromo")
    private List<VideogameData> detailsVideogames;
}
