package com.fzamiche.inventory_service.inventory_service.repository;

import com.fzamiche.inventory_service.inventory_service.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findBySku(String sku);
}
