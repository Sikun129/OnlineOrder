package com.payment.onlineorder.Repositories;

import com.payment.onlineorder.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
