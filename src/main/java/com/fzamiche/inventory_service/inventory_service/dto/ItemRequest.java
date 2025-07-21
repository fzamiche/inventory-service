package com.fzamiche.inventory_service.inventory_service.dto;

import com.fzamiche.inventory_service.inventory_service.model.Category;

public record ItemRequest(Long id, String sku,
                          String name,
                          int quantity, String location, Category category) {
}
