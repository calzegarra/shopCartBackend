package com.shopcart.jpa.cart;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface CartDataRepository extends CrudRepository<CartData, BigInteger>,
        QueryByExampleExecutor<CartData> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE tb_carrito " +
            " SET total_estimado = :total" +
            " WHERE  id_carrito = :id", nativeQuery = true)
    void updateTotalCart(@Param("total") BigDecimal total,@Param("id")  Integer id);

    @Query(value = "SELECT id_carrito, id_usuario, total_estimado, fecha_registro " +
            "FROM futuredb.tb_carrito v WHERE id_usuario = :id_usuario order by id_carrito desc", nativeQuery = true)
    List<Object[]> findMyCarts(@Param("id_usuario") Integer id);
}
