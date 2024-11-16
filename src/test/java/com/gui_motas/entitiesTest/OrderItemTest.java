
package com.gui_motas.entitiesTest;

import com.gui_motas.workshop_spring_jpa.entities.Order;
import com.gui_motas.workshop_spring_jpa.entities.OrderItem;
import com.gui_motas.workshop_spring_jpa.entities.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderItemTest {

    @Test
    public void testGetSubTotal() {
        Order order = new Order();
        Product product = new Product();
        OrderItem orderItem = new OrderItem(order, product, 2, 50.0);

        Double subTotal = orderItem.getSubTotal();

        assertEquals(100.0, subTotal);
    }

    @Test
    public void testGetSubTotalWithNullPrice() {
        Order order = new Order();
        Product product = new Product();
        OrderItem orderItem = new OrderItem(order, product, 2, null);

        assertThrows(NullPointerException.class, orderItem::getSubTotal);
    }

    @Test
    public void testGetSubTotalWithNullQuantity() {
        Order order = new Order();
        Product product = new Product();
        OrderItem orderItem = new OrderItem(order, product, null, 50.0);

        assertThrows(NullPointerException.class, orderItem::getSubTotal);
    }

    @Test
    public void testGetSubTotalWithNegativePrice() {
        Order order = new Order();
        Product product = new Product();
        OrderItem orderItem = new OrderItem(order, product, 2, -50.0);

        Double subTotal = orderItem.getSubTotal();

        assertEquals(-100.0, subTotal);
    }

    @Test
    public void testGetSubTotalWithNegativeQuantity() {
        Order order = new Order();
        Product product = new Product();
        OrderItem orderItem = new OrderItem(order, product, -2, 50.0);

        Double subTotal = orderItem.getSubTotal();

        assertEquals(-100.0, subTotal);
    }

    @Test
    public void testGetSubTotalWithLargeValues() {
        Order order = new Order();
        Product product = new Product();
        OrderItem orderItem = new OrderItem(order, product, Integer.MAX_VALUE, Double.MAX_VALUE);

        Double subTotal = orderItem.getSubTotal();

        assertTrue(subTotal.isInfinite());
    }
}