package org.flipkart.service;

import org.flipkart.model.Category;
import org.flipkart.model.Item;
import org.flipkart.repository.ItemRepository;

import java.util.List;

public class ItemService {

    final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
       this.itemRepository = itemRepository;
    }

    //can replace this with an api like GET  /items
    public List<Item> getListOfItems() {
        return itemRepository.getList();
    }
/*
    public List<Item> getListOfItemsByCategory(Category category) {
        return itemRepository.getListByCategory(category);
    }

    public List<Item> getListOfItemsByBrand(String brand) {
        return itemRepository.getListByBrand(brand);
    }
*/
}
