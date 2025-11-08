package com.shopcart.model.common.purchase;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
public class DtoMyCart {
    private Integer cartId;
    private Integer userId;
    private BigDecimal total;
    private LocalDateTime createDate;


    public DtoMyCart(Integer cartId,
                     Integer userId,
                     BigDecimal total,
                     LocalDateTime createDate) {
        this.cartId = cartId;
        this.userId = userId;
        this.total = total;
        this.createDate = createDate;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

}


