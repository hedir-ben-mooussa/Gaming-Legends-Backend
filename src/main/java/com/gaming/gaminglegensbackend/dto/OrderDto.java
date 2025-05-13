package com.gaming.gaminglegensbackend.dto;

import com.gaming.gaminglegensbackend.enums.PaymentType;
import com.gaming.gaminglegensbackend.enums.Status;


public class OrderDto {


    public String email;
    private float totalPrice;
    private Status status;
    private PaymentType paymentType;
    private String address;
    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    private String country;

    public Status getStatus() {
        return status;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public String getAddress() {
        return address;
    }


}
