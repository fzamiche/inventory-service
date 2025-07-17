package com.fzamiche.inventory_service.inventory_service.dto;

public record ItemRequest(Long id, String sku,
                          String name,
                          int quantity, String location) {
}
