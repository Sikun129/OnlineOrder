package com.payment.onlineorder.preLoader;

import com.payment.onlineorder.Entity.MenuItem;
import com.payment.onlineorder.Repositories.MenuItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final MenuItemRepository menuItemRepository;
    @Override
    public void run(String... args) throws Exception {
        menuItemRepository.save(MenuItem.builder()
                .name("Margherita Pizza")
                .description("Cheese & Basil")
                .price(new BigDecimal("12.99"))
                .build());

        menuItemRepository.save(MenuItem.builder()
                .name("Cheeseburger")
                .description("Beef & Cheddar")
                .price(new BigDecimal("9.50"))
                .build());
    }
}
