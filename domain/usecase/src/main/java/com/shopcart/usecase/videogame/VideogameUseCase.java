package com.shopcart.usecase.videogame;

import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.catalog.DtoCatalog;
import com.shopcart.model.common.exception.ShoppingCartException;
import com.shopcart.model.videogame.Videogame;
import com.shopcart.model.videogame.gateway.VideogameRepository;
import com.shopcart.usecase.util.ConstantsMessages;
import com.shopcart.usecase.util.GeneralUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class VideogameUseCase {
    private final VideogameRepository videogameRepository;
    private final GeneralUseCase generalUseCase;
    private ResponseData responseData;
    private Videogame videoNow;


    public ResponseData createVideogame(Videogame videogame) throws IOException {
        responseData = new ResponseData();
        if (!validateObject(videogame)) {
           // videogame.setCreateDate(LocalDateTime.now());
           // videogame.setState(Boolean.TRUE);
          //  videogame.setCreateBy("userEmp");
            responseData.setData(videogameRepository.save(videogame));
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            responseData.setMessage(ConstantsMessages.RECORD_EMPTY);
        }
        return responseData;
    }

    private boolean validateObject(Videogame videogame) throws IOException {
        return Stream.of(videogame.getTitle(),videogame.getDescription()).anyMatch(this::isInvalid)
                || videogame.getConsole() == null || videogame.getHasDiscount() == null
                || videogame.getStock() == null || videogame.getStock() <= 0  ||
                videogame.getPrice().compareTo(BigDecimal.ZERO) < 0;
    }

    private boolean isInvalid(String value) {
        return value == null || value.trim().isEmpty();
    }

    @Transactional
    public ResponseData updateVideogame(Videogame videogame)
            throws ShoppingCartException, IOException {
        responseData = new ResponseData();
        videoNow = new Videogame();
        videoNow = videogameRepository.findById(videogame.getId());
        if (videoNow != null) {
            if (!validateObject(videogame)) {
                changeAttributes(videogame);
            }
            responseData.setData(videogameRepository.save(videoNow));
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            throw new ShoppingCartException(400, ConstantsMessages.RECORD_EMPTY);
        }
        return responseData;
    }


    private void changeAttributes(Videogame videogame) {
        videoNow.setTitle(videogame.getTitle());
        videoNow.setDescription(videogame.getDescription());
        videoNow.setConsole(videogame.getConsole());
        videoNow.setHasDiscount(videogame.getHasDiscount());
        videoNow.setStock(videogame.getStock());
        videoNow.setPrice(videogame.getPrice());
        videoNow.setImage(videogame.getImage());
        videoNow.setImage2(videogame.getImage2());
        videoNow.setImage3(videogame.getImage3());
        videoNow.setMini(videogame.getMini());
        videoNow.setDetailsCategories(videogame.getDetailsCategories());
        videoNow.setDetailsPromo(videogame.getDetailsPromo());
    }

    @Transactional(readOnly = true)
    public ResponseData findById(BigInteger id) throws IOException{
        responseData = new ResponseData();
        Videogame promo = videogameRepository.findById(id);
      /*  if(promo.getImage2() != null){
            byte[] thumbnail = generalUseCase.createThumbnail(promo.getImage3(), 248, 140);
            promo.setMini(thumbnail);
            Videogame obj = videogameRepository.save(promo);
            System.out.println("Tamaño del mini: " + promo.getMini().length);
        }*/
        if (promo != null) {
            responseData.setData(promo);
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
        List<Videogame> list = videogameRepository.findAll();
        responseData.setStatus(Boolean.TRUE);
        if (!list.isEmpty()) {
            responseData.setData(list);
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
        }else {
            responseData.setMessage(ConstantsMessages.NOT_RECORD_EXIST);
        }
        return responseData;
    }

    public ResponseData findCatalog() {
        responseData = new ResponseData();
        List<DtoCatalog> list = videogameRepository.findCatalogNativeManual();
        responseData.setStatus(Boolean.TRUE);
        if (!list.isEmpty()) {
            responseData.setData(list);
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
        }else {
            responseData.setMessage(ConstantsMessages.NOT_RECORD_EXIST);
        }
        return responseData;
    }

    public ResponseData findAllGames() {
        responseData = new ResponseData();
        List<DtoCatalog> list = videogameRepository.findCatalogNativeManual();
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
