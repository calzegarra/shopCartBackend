package com.shopcart.usecase.cart;

import com.shopcart.model.cart.Cart;
import com.shopcart.model.cart.gateway.CartRepository;
import com.shopcart.model.cartItem.CartItem;
import com.shopcart.model.cartItem.gateway.CartItemRepository;
import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.catalog.DtoCatalog;
import com.shopcart.model.common.exception.ShoppingCartException;
import com.shopcart.model.common.purchase.DtoMyCart;
import com.shopcart.model.common.purchase.DtoMyProducts;
import com.shopcart.model.common.purchase.DtoPurchases;
import com.shopcart.model.common.review.DtoRequestReview;
import com.shopcart.model.productitem.DtoBuyItems;
import com.shopcart.model.productitem.DtoProductItem;
import com.shopcart.model.technicalogs.gateways.ILogger;
import com.shopcart.model.user.User;
import com.shopcart.model.videogame.gateway.VideogameRepository;
import com.shopcart.usecase.util.ConstantsMessages;
import com.shopcart.usecase.util.GeneralUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class CartUseCase {
    private final CartRepository cartRepository;
    private final CartItemRepository itemRepository;
    private final VideogameRepository gameRepository;
    private final GeneralUseCase generalUseCase;
    private final ILogger log;
    private Cart obj;
    private ResponseData responseData;


    public ResponseData buyProducts(DtoBuyItems cart) throws ShoppingCartException {
        responseData = new ResponseData();
        obj = new Cart();
        BigInteger cartId = createCart(cart.getUser());
        if (!cart.getDetailItems().isEmpty()) {
            setItemsInCart(cart.getDetailItems(), cartId);
            overrideTotal(cartId,cart.getDetailItems());
            DtoPurchases myPurchase = prepareData(cart);
            responseData.setData(myPurchase);
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            responseData.setMessage(ConstantsMessages.RECORD_EMPTY);
        }
        return responseData;
    }

    private BigInteger createCart(User user) throws ShoppingCartException {
        try {
            obj.setUser(user);
            obj.setCartState("COMPRADO");
            obj.setCreateDate(LocalDateTime.now());
            obj.setTotal(null);
            obj.setDetailsVideogames(Collections.emptyList());
            Cart myCart = cartRepository.save(obj);
            obj.setId(myCart.getId());
            log.info("El carrito fue creado exitosamente: " + obj.getId());
            return myCart.getId();
        } catch (Exception e) {
            log.error("Error al crear el carrito: " + e.getMessage());
            throw new ShoppingCartException(400,"Error al validar al crear el carrito." + e);
        }
    }

    private void setItemsInCart(List<DtoProductItem> items, BigInteger cartId) throws ShoppingCartException {
        try {
            itemRepository.insertItems(items, cartId);
        } catch (Exception e) {
            throw new ShoppingCartException(400,"Error al insertar los productos en el carrito." + e);
        }
    }

    private BigDecimal calculateTotal(List<DtoProductItem> items) {
        return items.stream()
                .map(item -> {
                    BigDecimal discountFactor = BigDecimal.ONE.subtract(
                            item.getUnitDiscount() != null ? item.getUnitDiscount() : BigDecimal.ZERO
                    );
                    return item.getUnitPrice()
                            .multiply(discountFactor)
                            .multiply(BigDecimal.valueOf(item.getAmount()));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private DtoPurchases prepareData(DtoBuyItems cart) {
        List<DtoMyProducts> details = new  ArrayList<>();
        for (DtoProductItem item :  cart.getDetailItems()) {
            DtoCatalog game = gameRepository.findItemProduct(item.getVideogameId().intValue());
            DtoMyProducts myProducts = new DtoMyProducts();
            myProducts.setTitle(game.getTitle());
            myProducts.setAmount(item.getAmount());
            myProducts.setUnitPrice(item.getUnitPrice());
            myProducts.setUnitDiscount(item.getUnitDiscount());
            myProducts.setSubtotal(item.getSubtotal());
            myProducts.setMini(game.getMini());
            details.add(myProducts);
        }
        DtoPurchases myPurchases = new DtoPurchases();
        myPurchases.setUser(cart.getUser().getName());
        myPurchases.setCreateDate(obj.getCreateDate());
        myPurchases.setTotal(calculateTotal(cart.getDetailItems()));
        myPurchases.setDetailItems(details);
        return myPurchases;
    }

    private void overrideTotal(BigInteger cartId, List<DtoProductItem> items) {
        BigDecimal total = calculateTotal(items);
        cartRepository.updateTotalCart(total, cartId.intValue());
        log.info("Total de carrito actualizado exitosamente ");
    }

    @Transactional(readOnly = true)
    public ResponseData findById(BigInteger id) {
        responseData = new ResponseData();
        Cart cart = cartRepository.findById(id);
        if (cart != null) {
            responseData.setData(cart);
            responseData.setMessage(ConstantsMessages.LIST_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            responseData.setMessage(ConstantsMessages.NOT_RECORD_EXIST);
        }
        return responseData;
    }

    public ResponseData findAllMyCarts(BigInteger userId) {
        responseData = new ResponseData();
        List<DtoMyCart> list =  cartRepository.findMyCarts(userId.intValue());
        responseData.setStatus(Boolean.TRUE);
        if (!list.isEmpty()) {
            responseData.setData(list);
            responseData.setMessage(ConstantsMessages.LIST_RECORD_SUCCESS);
        }else {
            responseData.setMessage(ConstantsMessages.NOT_RECORD_EXIST);
        }
        return responseData;
    }

    public ResponseData updateReview(Integer id,DtoRequestReview review)  {
        responseData = new ResponseData();
        itemRepository.updateReview(id, review);
        responseData.setData(review);
        responseData.setMessage(ConstantsMessages.UPDATE_RECORD_SUCCESS);
        responseData.setStatus(Boolean.TRUE);
        return responseData;
    }
}
