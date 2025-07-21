package com.fzamiche.inventory_service.inventory_service.repository;

import com.fzamiche.inventory_service.inventory_service.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String catName);
}
