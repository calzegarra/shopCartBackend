package com.shopcart.config;

import com.shopcart.model.role.gateway.RoleRepository;
import com.shopcart.usecase.role.RoleUseCase;
import org.reactivecommons.utils.ObjectMapper;
import org.reactivecommons.utils.ObjectMapperImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapperImp();
    }

}
