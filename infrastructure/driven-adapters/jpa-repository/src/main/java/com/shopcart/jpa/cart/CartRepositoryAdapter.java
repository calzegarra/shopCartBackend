package com.shopcart.jpa.cart;

import com.shopcart.jpa.util.ConverterMapper;
import com.shopcart.model.cart.Cart;
import com.shopcart.model.cart.gateway.CartRepository;
import com.shopcart.model.common.catalog.DtoCatalog;
import com.shopcart.model.common.purchase.DtoMyCart;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shopcart.generic.AdapterOperations;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CartRepositoryAdapter extends AdapterOperations <Cart, CartData, BigInteger, CartDataRepository>
        implements CartRepository {

    @Autowired
    public CartRepositoryAdapter(CartDataRepository repository, ObjectMapper mapper, ConverterMapper converterMapper) {
        super(repository, mapper, converterMapper::toEntityCart);
    }

    @Override
    public void updateTotalCart(BigDecimal total, Integer id) {
        repository.updateTotalCart(total, id);
    }

    @Override
    public List<DtoMyCart> findMyCarts(Integer userId) {
        List<Object[]> rows = repository.findMyCarts(userId);
        return rows.stream().map(r ->
                new DtoMyCart(
                        (Integer) r[0],
                        (Integer) r[1],
                        (BigDecimal) r[2],
                        ((Timestamp) r[3]).toLocalDateTime()
                )
        ).collect(Collectors.toList());
    }
}
