package com.shopcart.usecase.promo;


import com.shopcart.model.common.ResponseData;
import com.shopcart.model.common.exception.ShoppingCartException;
import com.shopcart.model.promo.Promotion;
import com.shopcart.model.promo.gateway.PromoRepository;
import com.shopcart.usecase.util.ConstantsMessages;
import lombok.RequiredArgsConstructor;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class PromoUseCase {
    private final PromoRepository promoRepository;
    private ResponseData responseData;
    private Promotion promoNow;

    public ResponseData createPromo(Promotion promo) {
        responseData = new ResponseData();
        if (!validateObject(promo)) {
            promo.setCreateDate(LocalDateTime.now());
            promo.setState(Boolean.TRUE);
            promo.setCreateBy("userEmp");
            responseData.setData(promoRepository.save(promo));
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            responseData.setMessage(ConstantsMessages.RECORD_EMPTY);
        }
        return responseData;
    }

    private boolean validateObject(Promotion promo) {
        return Stream.of(promo.getDescription()).anyMatch(this::isInvalid)
                || promo.getDiscount() == null || promo.getDiscount() <= 0
                || promo.getStartDate() == null || promo.getEndDate() == null
                || promo.getEndDate().isBefore(promo.getStartDate());
    }

    private boolean isInvalid(String value) {
        return value == null || value.trim().isEmpty();
    }


    public ResponseData updatePromo(Promotion promo)
            throws ShoppingCartException {
        responseData = new ResponseData();
        promoNow = new Promotion();
        promoNow = promoRepository.findById(promo.getId());
        if (promoNow != null) {
            changeAttributes(promo);
            responseData.setData(promoRepository.save(promoNow));
            responseData.setMessage(ConstantsMessages.CREATE_RECORD_SUCCESS);
            responseData.setStatus(Boolean.TRUE);
        }else {
            responseData.setStatus(Boolean.FALSE);
            throw new ShoppingCartException(400, ConstantsMessages.RECORD_EMPTY);
        }
        return responseData;
    }

    private void changeAttributes(Promotion promo) {
        promoNow.setDescription(promo.getDescription());
        promoNow.setDiscount(promo.getDiscount());
        promoNow.setStartDate(promo.getStartDate());
        promoNow.setEndDate(promo.getEndDate());
        promoNow.setState(promo.getState());
        promoNow.setImagePromo(promo.getImagePromo());
    }

    public ResponseData findById(BigInteger id) {
        responseData = new ResponseData();
        Promotion promo = promoRepository.findById(id);
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
        List<Promotion> list = promoRepository.findAll();
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
