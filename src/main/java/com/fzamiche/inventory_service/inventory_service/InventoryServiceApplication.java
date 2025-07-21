package com.fzamiche.inventory_service.inventory_service;

import com.fzamiche.inventory_service.inventory_service.model.Category;
import com.fzamiche.inventory_service.inventory_service.model.Item;
import com.fzamiche.inventory_service.inventory_service.repository.CategoryRepository;
import com.fzamiche.inventory_service.inventory_service.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ItemRepository itemRepository, CategoryRepository categoryRepository) {
        return args -> {
            Category accessoires = Category.builder()
                    .name("Accessoires")
                    .build();

            Category informatique = Category.builder()
                    .name("Informatique")
                    .build();

            categoryRepository.saveAll(List.of(accessoires, informatique));

            Item souris = Item.builder()
                    .sku("SKU001")
                    .name("Souris sans fil")
                    .quantity(50)
                    .location("Stock A")
                    .category(accessoires)
                    .build();

            Item clavier = Item.builder()
                    .sku("SKU002")
                    .name("Clavier mécanique")
                    .quantity(30)
                    .location("Stock A")
                    .category(accessoires)
                    .build();

            Item ecran = Item.builder()
                    .sku("SKU003")
                    .name("Écran 24 pouces")
                    .quantity(20)
                    .location("Stock B")
                    .category(informatique)
                    .build();

            Item disque = Item.builder()
                    .sku("SKU004")
                    .name("Disque dur SSD")
                    .quantity(40)
                    .location("Stock C")
                    .category(informatique)
                    .build();

            itemRepository.saveAll(List.of(souris, clavier, ecran, disque));
        };
    }

}

