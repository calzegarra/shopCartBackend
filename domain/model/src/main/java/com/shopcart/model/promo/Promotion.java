package com.shopcart.model.promo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shopcart.model.videogame.Videogame;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class Promotion {
    private BigInteger id;
    private String description;
    private Double discount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean state;
    private byte[] imagePromo;
    private LocalDateTime createDate;
    private String createBy;
    @JsonIgnore
    private List<Videogame> detailsVideogames;

}
