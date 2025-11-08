package com.shopcart.api.videogame;

import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.exception.ShoppingCartException;
import com.shopcart.model.videogame.Videogame;
import com.shopcart.usecase.videogame.VideogameUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.math.BigInteger;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/api/videogame", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class VideogameService {
    private final VideogameUseCase useCase;
    private ResponseData responseData;

    @PreAuthorize("hasRole('EMPLEADO')")
    @PostMapping(path = "/create")
    public ResponseData createVideogame(@Validated @RequestBody Videogame data)
            throws ShoppingCartException, IOException {
         responseData = useCase.createVideogame(data);
        if (responseData.getStatus()) {
            responseData.setCode(HttpStatus.CREATED.value());
        } else {
            responseData.setCode(HttpStatus.BAD_REQUEST.value());
        }
        return responseData;
    }

    @PreAuthorize("hasRole('EMPLEADO')")
    @PostMapping(path = "/update")
    public ResponseData updateVideogame(@Validated @RequestBody Videogame data)
            throws ShoppingCartException, IOException {
        responseData = useCase.updateVideogame(data);
        if (responseData.getStatus()) {
            responseData.setCode(HttpStatus.CREATED.value());
        } else {
            responseData.setCode(HttpStatus.BAD_REQUEST.value());
        }
        return responseData;
    }

    @PreAuthorize("hasRole('EMPLEADO')")
    @GetMapping(path = "/findById/{id}")
    public ResponseData findById(@PathVariable BigInteger id) throws IOException{
         responseData = useCase.findById(id);
        if (responseData.getStatus()) {
            responseData.setCode(HttpStatus.CREATED.value());
        } else {
            responseData.setCode(HttpStatus.BAD_REQUEST.value());
        }
        return responseData;
    }

    @PreAuthorize("hasRole('EMPLEADO')")
    @GetMapping(path = "/findAll")
    public ResponseData findAll(){
        responseData = useCase.findAll();
        responseData.setCode(HttpStatus.CREATED.value());
        return responseData;
    }


    @GetMapping(path = "/findCatalog")
    public ResponseData findCatalog(){
        responseData = useCase.findCatalog();
        responseData.setCode(HttpStatus.CREATED.value());
        return responseData;
    }

    @PreAuthorize("hasRole('EMPLEADO')")
    @GetMapping(path = "/findAllVideogames")
    public ResponseData findAllVideogames(){
        responseData = useCase.findCatalog();
        responseData.setCode(HttpStatus.CREATED.value());
        return responseData;
    }
}
