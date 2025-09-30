package com.shopcart.model.videogamecategory;

import com.shopcart.model.category.Category;
import com.shopcart.model.videogame.Videogame;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class VideogameCategory {
    private Integer id;
    private Videogame videogame;
    private Category category;
}
