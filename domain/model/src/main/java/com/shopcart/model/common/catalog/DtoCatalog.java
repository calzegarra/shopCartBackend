package com.shopcart.model.common.catalog;

import lombok.Builder;
import java.math.BigDecimal;


@Builder(toBuilder = true)
public class DtoCatalog {
    private Integer id;
    private Integer consoleId;
    private String title;
    private Byte hasDiscount;
    private BigDecimal price;
    private String state;
    private byte[] mini;

public DtoCatalog(Integer id,
                  Integer consoleId,
                  String title,
                  Byte hasDiscount,
                  BigDecimal price,
                  String state,
                  byte[] mini) {
    this.id = id;
    this.consoleId = consoleId;
    this.title = title;
    this.hasDiscount = hasDiscount;
    this.price = price;
    this.state = state;
    this.mini = mini;
   }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(Integer consoleId) {
        this.consoleId = consoleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(Byte hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public byte[] getMini() {
        return mini;
    }

    public void setMini(byte[] mini) {
        this.mini = mini;
    }
}