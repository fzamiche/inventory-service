package com.fzamiche.inventory_service.inventory_service;

import com.fzamiche.inventory_service.inventory_service.model.Item;
import com.fzamiche.inventory_service.inventory_service.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ItemRepository itemRepository) {
        return args ->
                itemRepository.save(
                        Item.builder()
                                .sku("ABC123")
                                .name("Wireless Mouse")
                                .quantity(120)
                                .location("Warehouse A")
                                .build()
                );
    }
}

