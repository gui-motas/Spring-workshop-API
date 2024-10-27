package com.gui_motas.workshop_spring_jpa.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gui_motas.workshop_spring_jpa.entities.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;


@Entity @Table(name = "tb_order")
public @Data @AllArgsConstructor @NoArgsConstructor @Builder class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE) Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public static class OrderBuilder {
        public OrderBuilder orderStatus(OrderStatus orderStatus) {
            if (orderStatus != null) {
                this.orderStatus = orderStatus.getCode();
            }
            return this;
        }
    }

}

