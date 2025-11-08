package com.shopcart.model.videogame.gateway;

import com.shopcart.model.common.catalog.DtoCatalog;
import com.shopcart.model.videogame.Videogame;
import java.math.BigInteger;
import java.util.List;

public interface VideogameRepository {
    Videogame save(Videogame videogame);
    Videogame findById(BigInteger id);
    List<Videogame> findByExample(Videogame videogame);
    List<Videogame> findAll();
    List<DtoCatalog> findCatalogNativeManual();
    DtoCatalog findItemProduct(Integer id);
}
