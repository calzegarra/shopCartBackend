package com.shopcart.model.cartItem.gateway;

import com.shopcart.model.cartItem.CartItem;
import com.shopcart.model.common.purchase.DtoMyCart;
import com.shopcart.model.common.review.DtoRequestReview;
import com.shopcart.model.productitem.DtoProductItem;

import java.math.BigInteger;
import java.util.List;

public interface CartItemRepository {
    void insertItems(List<DtoProductItem> items, BigInteger cartId);
    CartItem save(CartItem item);
    CartItem findById(BigInteger id);
    void updateReview(Integer itemId, DtoRequestReview review);
    List<CartItem> findByExample(CartItem console);
}
