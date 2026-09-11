package com.payment.onlineorder.Service;

import com.payment.onlineorder.Dto.CreateOrderRequest;
import com.payment.onlineorder.Dto.OrderItemRequest;
import com.payment.onlineorder.Entity.MenuItem;
import com.payment.onlineorder.Entity.Order;
import com.payment.onlineorder.Entity.OrderItem;
import com.payment.onlineorder.Repositories.MenuItemRepository;
import com.payment.onlineorder.Repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService   {

    private final MenuItemRepository menuItemRepository;
    private final OrderRepository orderRepository;

    public Order placeOrder(CreateOrderRequest request){
        Order order = Order.builder()
                .userId(request.userId())
                .status("PENDING")
                .totalAmount(BigDecimal.ZERO)
                .build();

        BigDecimal total = BigDecimal.ZERO;

        for (OrderItemRequest itemReq : request.item()){
            MenuItem menuItem = menuItemRepository.findById(itemReq.menuItemId())
                    .orElseThrow(()-> new RuntimeException("Item not found:" + itemReq.menuItemId()));

            OrderItem orderItem = OrderItem.builder()
                    .menuItemId(menuItem.getId())
                    .quantity(itemReq.quantity())
                    .price(menuItem. getPrice())
                    .build();

            order.getItem().add(orderItem);

            BigDecimal lineTotal = menuItem.getPrice().multiply(BigDecimal.valueOf(itemReq.quantity()));
            total = total.add(lineTotal);
        }
        order.setTotalAmount(total);
        return orderRepository.save(order);
    }

    public List<MenuItem> fetchMenuId(){
        return menuItemRepository.findAll();
    }

}
