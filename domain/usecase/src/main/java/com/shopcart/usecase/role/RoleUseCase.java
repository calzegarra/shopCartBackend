package com.shopcart.usecase.role;

import com.shopcart.usecase.util.ConstantsMessages;
import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.exception.ShoppingCartException;
import com.shopcart.model.role.Role;
import com.shopcart.model.role.gateway.RoleRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RoleUseCase {
    private final RoleRepository roleRepository;
    private ResponseData responseData;

    public ResponseData createRole(Role role)
            throws ShoppingCartException {
        responseData = new ResponseData();
        if (!role.getDescription().isEmpty()) {
            responseData.setData(roleRepository.save(role));
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            throw new ShoppingCartException(400, ConstantsMessages.CREATE_RECORD_FAILED);
        }
        return responseData;
    }

    public ResponseData findAllRoles() {
        responseData = new ResponseData();
        List<Role> roleList = roleRepository.findAll();
        if (!roleList.isEmpty()){
            responseData.setData(roleList);
            responseData.setMessage(ConstantsMessages.LIST_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else{
            responseData.setMessage(ConstantsMessages.LIST_RECORD_EMPTY);
            responseData.setStatus(Boolean.FALSE);
        }
        return responseData;
    }
}
