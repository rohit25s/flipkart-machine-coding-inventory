package org.flipkart.repository;

import org.flipkart.exceptions.ItemNotFoundException;
import org.flipkart.exceptions.QuantityExceedsException;
import org.flipkart.model.Category;
import org.flipkart.model.Item;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ItemRepository {
    public Map<Item, Integer> itemMap;
    List<Item> items;

    public ItemRepository(){
        itemMap = new HashMap<>();
        items = new ArrayList<>();
    }

    public void reduceQuantity(Item item, int quantity) throws ItemNotFoundException,QuantityExceedsException {

        if(itemMap.get(item)==null)
            throw new ItemNotFoundException("item not found");
        System.out.println("qunatity of item"+ itemMap.get(item));
        if(itemMap.get(item)<quantity)
            throw new QuantityExceedsException("quantity not available");
        itemMap.put(item,itemMap.get(item));
    }

    public void addQuantity(Item item, int quantity){
        items.add(item);
        itemMap.put(item, itemMap.getOrDefault(item,0)+1);
    }

    public List<Item> getList(){
        return items;
    }

    public List<Item> getListByBrand(List<String> brands,Category category){
        List<Item> resulting= getList();
        List<Item> resultingNew= getList();
       // for(Item item: resulting)

                   // if(brands.contains(item.getbrand()))
                    //  resultingNew.add(item);
           return resultingNew;
    }

}
