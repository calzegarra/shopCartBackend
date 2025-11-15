package com.shopcart.jpa.cartitem;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;

public interface CartItemDataRepository extends CrudRepository<CartItemData, BigInteger>,
        QueryByExampleExecutor<CartItemData> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tb_carrito_item " +
            "(id_carrito, id_videojuegos, cantidad, precio_unitario, descuento_unitario, subtotal, fecha_registro) " +
            "VALUES (?1, ?2, ?3, ?4, ?5, ?6, NOW())",
            nativeQuery = true)
    void insertItem(Integer idCarrito, Integer idVideogame, Integer cantidad, BigDecimal precio,
                   BigDecimal descuento, BigDecimal subtotal);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tb_carrito_item " +
            "SET puntaje = :score,  comentario = :comment,  fecha_comentario = NOW()" +
            " WHERE  id_item = :id", nativeQuery = true)
    void updateReview(@Param("id")Integer id, @Param("score")Integer score, @Param("comment")String comment);
}
