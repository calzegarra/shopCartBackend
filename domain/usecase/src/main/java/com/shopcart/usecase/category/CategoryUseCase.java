package com.shopcart.usecase.category;

import com.shopcart.model.category.Category;
import com.shopcart.model.category.gateway.CategoryRepository;
import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.exception.ShoppingCartException;
import com.shopcart.usecase.util.ConstantsMessages;
import lombok.RequiredArgsConstructor;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class CategoryUseCase {
    private final CategoryRepository categoryRepository;
    private ResponseData responseData;
    private Category categoryNow;

    public ResponseData createCategory(Category category) {
        responseData = new ResponseData();
        if (!validateEmpty(category.getDescription())) {
            category.setCreateDate(LocalDateTime.now());
            category.setState(Boolean.TRUE);
            category.setCreateBy("userEmp");
            responseData.setData(categoryRepository.save(category));
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            responseData.setMessage(ConstantsMessages.RECORD_EMPTY);
        }
        return responseData;
    }

    private boolean validateEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public ResponseData updateCategory(Category category)
            throws ShoppingCartException {
        responseData = new ResponseData();
        categoryNow = new Category();
        categoryNow = categoryRepository.findById(category.getId());
        if (categoryNow != null) {
            changeAttributes(category);
            responseData.setData(categoryRepository.save(categoryNow));
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            throw new ShoppingCartException(400, ConstantsMessages.RECORD_EMPTY);
        }
        return responseData;
    }

    private void changeAttributes(Category category) {
        categoryNow.setDescription(category.getDescription());
        categoryNow.setState(category.getState());
    }

    public ResponseData findById(BigInteger id) {
        responseData = new ResponseData();
        Category category = categoryRepository.findById(id);
        if (category != null) {
            responseData.setData(category);
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            responseData.setMessage(ConstantsMessages.NOT_RECORD_EXIST);
        }
        return responseData;
    }

    public ResponseData findAll() {
        responseData = new ResponseData();
        List<Category> list = categoryRepository.findAll();
        responseData.setStatus(Boolean.TRUE);
        if (!list.isEmpty()) {
            responseData.setData(list);
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
        }else {
            responseData.setMessage(ConstantsMessages.NOT_RECORD_EXIST);
        }
        return responseData;
    }
}
