package com.payment.onlineorder.Controller;

import com.payment.onlineorder.Dto.CreateOrderRequest;
import com.payment.onlineorder.Entity.MenuItem;
import com.payment.onlineorder.Entity.Order;
import com.payment.onlineorder.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody CreateOrderRequest request){
        Order newOrder = orderService.placeOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }

    @GetMapping("/ids")
    public ResponseEntity<List<MenuItem>> fetchMenuId(){
        return  ResponseEntity.ok(orderService.fetchMenuId());
    }

    @GetMapping("/ids")
    public ResponseEntity<List<MenuItem>> fetchMenuId1(){
        return  ResponseEntity.ok(orderService.fetchMenuId());
    }
}
