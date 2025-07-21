package com.fzamiche.inventory_service.inventory_service.service;

import com.fzamiche.inventory_service.inventory_service.Exception.ResourceNotFoundException;
import com.fzamiche.inventory_service.inventory_service.dto.ItemRequest;
import com.fzamiche.inventory_service.inventory_service.model.Category;
import com.fzamiche.inventory_service.inventory_service.model.Item;
import com.fzamiche.inventory_service.inventory_service.repository.CategoryRepository;
import com.fzamiche.inventory_service.inventory_service.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    public ItemService(ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item not found - id : " + id));
    }

    public Long updateItemById(Long id, ItemRequest updatedItem) {
        Item existingItem = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item not found - id : " + id));

        if ((!existingItem.getSku().equals(updatedItem.sku()))
                && itemRepository.findBySku(updatedItem.sku()).stream()
                .anyMatch(item -> !item.getId().equals(id))) {
            throw new IllegalArgumentException("SKU déjà utilisé");
        }

        existingItem.setSku(updatedItem.sku());
        existingItem.setName(updatedItem.name());
        existingItem.setQuantity(updatedItem.quantity());
        existingItem.setLocation(updatedItem.location());
        existingItem.setCategory(updatedItem.category());

        return itemRepository.save(existingItem).getId();
    }

    public void deleteItemById(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new ResourceNotFoundException("Item not found - id : " + id);
        }
        itemRepository.deleteById(id);
    }

    public List<Item> getAllItemsByCategoryName(String categoryName) {
        return itemRepository.findByCategoryName(categoryName);
    }

    public List<Item> getAllItemsByQuantityLessThan(int quantity) {
        return itemRepository.findByQuantityLessThan(quantity);
    }

    public Double getAverageQuantityPerCategory(String categoryName) {
        return itemRepository.findAverageQuantityPerCategory(categoryName);
    }
}
