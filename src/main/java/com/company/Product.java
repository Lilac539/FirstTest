package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
    private String phoneName;
    private int phoneSale;
    private int phoneSalePrice;
    private int phonePrice;

    public Product(String phoneName, String phoneSale, String phoneSalePrice, String phonePrice ){
        this.phoneName = phoneName;
        this.phoneSale = Integer.parseInt(phoneSale.replaceAll("\\W", ""));
        this.phoneSalePrice = Integer.parseInt(phoneSalePrice.replaceAll("[\\W]", ""));
        this.phonePrice = Integer.parseInt(phonePrice.replaceAll("[\\W]", ""));
    }

    public String getPhoneName(){
        return phoneName;
    }

    public int getPhoneSale(){
        return phoneSale;
    }

    public int getPhoneSalePrice(){
        return phoneSalePrice;
    }

    public int getPhonePrice(){
        return phonePrice;
    }

    @Override
    public String toString() {
        return  "Марка телефона: " + phoneName  +
                ", Знижка: " + phoneSale + "%"+
                ", Ціна зі знижкою: " + phoneSalePrice +
                ", Ціна без знижки: " + phonePrice;
    }

}
