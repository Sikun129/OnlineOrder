package com.payment.onlineorder.Repositories;

import com.payment.onlineorder.Entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository  extends JpaRepository<MenuItem, Long> {
}
