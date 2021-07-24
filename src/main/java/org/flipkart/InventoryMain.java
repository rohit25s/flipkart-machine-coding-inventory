package org.flipkart;

import org.flipkart.model.Admin;
import org.flipkart.model.Category;
import org.flipkart.model.Item;
import org.flipkart.model.User;
import org.flipkart.repository.ItemRepository;
import org.flipkart.repository.UserRepository;
import org.flipkart.service.AdminService;
import org.flipkart.service.ItemService;
import org.flipkart.service.UserService;

import java.util.List;

public class InventoryMain {

    public static void main(String Args[]){

        ItemRepository itemRepository = new ItemRepository();
        UserRepository userRepository = new UserRepository();

        UserService userService = new UserService(itemRepository, userRepository);
        ItemService itemService  = new ItemService(itemRepository);
        AdminService adminService = new AdminService(itemRepository);
        User user1 = new User("abc", 1000);
        User user2 = new User("asafd", 300);
        User user3 = new User("adasd", 100);
        User user4 = new User("aadasc", 1440);


        Admin admin1 = new Admin("mod");

        Item item1 = new Item("a1", "amul", Category.MILK, 34);
        Item item5 = new Item("a6", "amul", Category.CHOCOLATES, 31);
        Item item2 = new Item("a2", "britannia", Category.CHOCOLATES, 100);
        Item item3 = new Item("a3", "nandini", Category.CURD, 20);
        Item item4 = new Item("a4", "freshco", Category.VEGETABLES, 10);

        adminService.addAdmin(admin1);
        adminService.addQuantityToItem(item1, 100);
        adminService.addQuantityToItem(item2, 10);
        adminService.addQuantityToItem(item3, 10);
        adminService.addQuantityToItem(item4, 50);

        adminService.addQuantityToItem(item5, 100);
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);


        System.out.println("before value:"+item1.getPrice());
        adminService.updatePrice(item1,200);
        System.out.println("value:"+item1.getPrice());

/*
        List<Item> li = itemService.getListOfItemsByBrand("amul");

        System.out.println("----------------list of items by brand amul---------------");
        for(Item item : li){
            System.out.println("itemPrice"+ item.getPrice()+" "+item.getCategory() );
        }
      */


        System.out.println("----------------cart items--------------");

        System.out.println("wallet value:"+user1.getWalletValue());
        userService.addItemToCart(user1, item1, 1);

        List<Item> list = userRepository.cart.get(user1);

        /*
        for(Item item : li){
            System.out.println(item.getPrice());
        }
        System.out.println("after wallet value:"+user1.getWalletValue());

*/
    }

}
