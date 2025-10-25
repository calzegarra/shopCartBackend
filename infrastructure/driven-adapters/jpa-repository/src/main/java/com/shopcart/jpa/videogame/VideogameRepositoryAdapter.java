package com.shopcart.jpa.videogame;

import com.shopcart.generic.AdapterOperations;
import com.shopcart.jpa.util.ConverterMapper;
import com.shopcart.model.common.catalog.DtoCatalog;
import com.shopcart.model.videogame.Videogame;
import com.shopcart.model.videogame.gateway.VideogameRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class VideogameRepositoryAdapter extends
        AdapterOperations<Videogame, VideogameData, BigInteger, VideogameDataRepository> implements VideogameRepository {

    @Autowired
    public VideogameRepositoryAdapter(VideogameDataRepository repository, ObjectMapper mapper,
                                      ConverterMapper converterMapper) {
        super(repository, mapper,  converterMapper::toEntityVideogame);
    }

    @Override
    public List<DtoCatalog> findCatalogNativeManual() {
        List<Object[]> rows = repository.listCatalogNative();
        return rows.stream().map(r ->
                new DtoCatalog(
                        (Integer) r[0],
                        (Integer) r[1],
                        (String) r[2],
                        (Byte) r[3],
                        (BigDecimal) r[4],
                        (String) r[5],
                        (byte[]) r[6]
                )
        ).collect(Collectors.toList());
    }
}
