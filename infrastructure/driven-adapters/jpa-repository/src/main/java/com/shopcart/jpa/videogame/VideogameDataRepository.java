package com.shopcart.jpa.videogame;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import java.math.BigInteger;
import java.util.List;

public interface VideogameDataRepository extends
        CrudRepository<VideogameData, BigInteger>, QueryByExampleExecutor<VideogameData> {

    @Query(value = "SELECT id_videojuegos, id_consola, titulo, tiene_desc, unidad_precio,estado,mini_imagen " +
            "FROM futuredb.tb_videojuegos v WHERE /* condiciones */ 1=1", nativeQuery = true)
    List<Object[]> listCatalogNative();

    @Query(value = "SELECT id_videojuegos, id_consola, titulo, tiene_desc, unidad_precio,estado,mini_imagen " +
            "FROM futuredb.tb_videojuegos v WHERE id_videojuegos = :id_videojuegos", nativeQuery = true)
    List<Object[]> findItemProduct(@Param("id_videojuegos") Integer id);

}
