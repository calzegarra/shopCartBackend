package com.shopcart.jpa.cartitem;

import com.shopcart.generic.AdapterOperations;
import com.shopcart.model.cartItem.CartItem;
import com.shopcart.model.cartItem.gateway.CartItemRepository;
import com.shopcart.model.common.review.DtoRequestReview;
import com.shopcart.model.productitem.DtoProductItem;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository
public class CartItemRepositoryAdapter extends AdapterOperations<CartItem, CartItemData, BigInteger, CartItemDataRepository>
        implements CartItemRepository {

    @Autowired
    public CartItemRepositoryAdapter(CartItemDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, CartItem.CartItemBuilder.class).build());
    }

    @Override
    public void insertItems(List<DtoProductItem> items, BigInteger cartId) {
        for (DtoProductItem item : items) {
            BigDecimal discountFactor = BigDecimal.ONE.subtract(
                    item.getUnitDiscount() != null ? item.getUnitDiscount() : BigDecimal.ZERO
            );

            BigDecimal subtotal = item.getUnitPrice()
                    .multiply(discountFactor)
                    .multiply(BigDecimal.valueOf(item.getAmount()));

            repository.insertItem(
                    cartId.intValue(),
                    item.getVideogameId().intValue(),
                    item.getAmount(),
                    item.getUnitPrice(),
                    item.getUnitDiscount(),
                    subtotal
            );
        }
    }

    @Override
    public void updateReview(Integer itemId, DtoRequestReview review) {
         super.repository.updateReview(itemId, review.getScore(), review.getComment());
    }
}
