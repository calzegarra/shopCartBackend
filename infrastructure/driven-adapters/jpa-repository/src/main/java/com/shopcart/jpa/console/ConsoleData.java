package com.shopcart.jpa.console;

import com.shopcart.jpa.videogame.VideogameData;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "tb_consola")
@NoArgsConstructor
public class ConsoleData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consola")
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
    @OneToMany(mappedBy = "console")
    private List<VideogameData> listVideogames;
}
