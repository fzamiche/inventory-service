package com.fzamiche.inventory_service.inventory_service.controller;

import com.fzamiche.inventory_service.inventory_service.dto.ItemRequest;
import com.fzamiche.inventory_service.inventory_service.model.Item;
import com.fzamiche.inventory_service.inventory_service.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {


    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getItems(@RequestParam(name = "qte_less_than", required = false) Integer quantity) {
        List<Item> items = (quantity != null)
                ? itemService.getAllItemsByQuantityLessThan(quantity)
                : itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
        Item createdItem = itemService.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItemById(@PathVariable Long id, @Valid @RequestBody ItemRequest itemRequest) {
        return ResponseEntity.ok(itemService.updateItemById(id, itemRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<List<Item>> getItemsByCategoryName(@PathVariable("name") String categoryName) {
        return ResponseEntity.ok(itemService.getAllItemsByCategoryName(categoryName));
    }

    @GetMapping("/category/{name}/stats/average-quantity")
    public ResponseEntity<Double> getAverageQuantityPerCategory(@PathVariable("name") String categoryName) {
        return ResponseEntity.ok(itemService.getAverageQuantityPerCategory(categoryName));
    }
}
