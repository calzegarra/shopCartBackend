package com.shopcart.model.productitem;

import com.shopcart.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class DtoBuyItems {
    private User user;
    private List<DtoProductItem> detailItems;
}
