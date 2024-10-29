package com.gui_motas.workshop_spring_jpa.entities;

import com.gui_motas.workshop_spring_jpa.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_order_item")
public @Data @Builder @AllArgsConstructor @NoArgsConstructor class OrderItem implements Serializable {

    private final static long serialVersionUID = 1L;

    @EmbeddedId
    private @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) OrderItemPK id = new OrderItemPK();
    private @EqualsAndHashCode.Exclude Integer quantity;
    private @EqualsAndHashCode.Exclude Double price;

    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public static class OrderItemBuilder {
        public OrderItem build(Order order, Product product) {
            if (this.id == null) {
                id.setOrder(order);
                id.setProduct(product);
            }
            return new OrderItem(id, quantity, price);
        }
    }

}
