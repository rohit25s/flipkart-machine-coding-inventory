package org.flipkart.service;

import org.flipkart.model.Admin;
import org.flipkart.model.Item;
import org.flipkart.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

public class AdminService {

    private ItemRepository itemRepository;
    private List<Admin> admins;
    public AdminService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
        this.admins = new ArrayList<>();
    }

    public void addAdmin(Admin admin){
        if(!admins.contains(admin))
            admins.add(admin);
    }


    public void addQuantityToItem(Item item, int quantity){
        itemRepository.addQuantity(item, quantity);
        System.out.println("quantity added");
    }

    public void updatePrice(Item item, double price){
        item.setPrice(price);
    }

}
