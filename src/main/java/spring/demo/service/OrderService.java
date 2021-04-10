package spring.demo.service;

import spring.demo.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}