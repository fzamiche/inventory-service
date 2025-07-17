package com.fzamiche.inventory_service.inventory_service.service;

import com.fzamiche.inventory_service.inventory_service.model.Item;
import com.fzamiche.inventory_service.inventory_service.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }
}
