package com.shopcart.model.console;

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
public class Console {
    private BigInteger id;
    private String description;
    private Boolean state;
    private LocalDateTime createDate;
    private String createBy;

    @JsonIgnore
    private List<Videogame> listVideogames;
}
