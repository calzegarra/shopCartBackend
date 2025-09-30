package com.shopcart.jpa.videogame;

import co.com.shopcart.jpa.AdapterOperations;
import com.shopcart.jpa.util.ConverterMapper;
import com.shopcart.model.videogame.Videogame;
import com.shopcart.model.videogame.gateway.VideogameRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;

@Repository
public class VideogameRepositoryAdapter extends
        AdapterOperations<Videogame, VideogameData, BigInteger, VideogameDataRepository> implements VideogameRepository {

    @Autowired
    public VideogameRepositoryAdapter(VideogameDataRepository repository, ObjectMapper mapper,
                                      ConverterMapper converterMapper) {
        super(repository, mapper,  converterMapper::toEntityVideogame);
    }
}
