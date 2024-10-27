package com.gui_motas.workshop_spring_jpa.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public @AllArgsConstructor enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);


    private @Getter int code;


    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

}
