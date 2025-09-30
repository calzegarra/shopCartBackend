package com.shopcart.model.videogamepromo;

import com.shopcart.model.promo.Promotion;
import com.shopcart.model.videogame.Videogame;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class VideogamePromo {
    private Integer id;
    private Videogame videogame;
    private Promotion promotion;
}
