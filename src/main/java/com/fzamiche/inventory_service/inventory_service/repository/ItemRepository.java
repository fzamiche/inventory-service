package com.fzamiche.inventory_service.inventory_service.repository;

import com.fzamiche.inventory_service.inventory_service.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findBySku(String sku);

    List<Item> findByCategoryName(String name);

    List<Item> findByQuantityLessThan(int quantity);

    @Query("""
            select AVG(i.quantity)
                        from Item i
                                    where i.category.name = :name
            """)
    Double findAverageQuantityPerCategory(String name);
}
