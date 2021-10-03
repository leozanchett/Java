package com.example.curso.entities.enums;

import com.example.curso.entities.Order;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int Code;

    private OrderStatus(int i) {
        this.Code = i;
    }

    public int getCode(){
        return Code;
    }

    public static OrderStatus valueOf(int code){
        for(OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatusCode");
    }
}
