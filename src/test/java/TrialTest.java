import org.flipkart.model.Admin;
import org.flipkart.model.Category;
import org.flipkart.model.Item;
import org.flipkart.model.User;
import org.flipkart.repository.ItemRepository;
import org.flipkart.repository.UserRepository;
import org.flipkart.service.AdminService;
import org.flipkart.service.ItemService;
import org.flipkart.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TrialTest {

    ItemRepository itemRepository;
    UserRepository userRepository;
    static UserService userService;
    static ItemService itemService;
    static AdminService adminService;

    @BeforeAll
    public void setUp() {

        itemRepository = new ItemRepository();
        userRepository = new UserRepository();
    }


    @Test
    @DisplayName("Create user")
    public void testCreate(){
        userService = new UserService(itemRepository, userRepository);
        itemService  = new ItemService(itemRepository);
        adminService = new AdminService(itemRepository);
        System.out.println("test");
        User user1 = new User("abc", 1000);
        User user2 = new User("asafd", 300);
        User user3 = new User("adasd", 100);
        User user4 = new User("aadasc", 1440);


        Admin admin1 = new Admin("mod");

        Item item1 = new Item("a1", "amul", Category.MILK, 34);
        Item item2 = new Item("a2", "britannia", Category.CHOCOLATES, 100);
        Item item3 = new Item("a3", "nandini", Category.CURD, 20);
        Item item4 = new Item("a4", "freshco", Category.VEGETABLES, 10);

        adminService.addAdmin(admin1);
        adminService.addQuantityToItem(item1, 100);
        adminService.addQuantityToItem(item2, 10);
        adminService.addQuantityToItem(item3, 10);
        adminService.addQuantityToItem(item4, 50);

        Assertions.assertEquals(user1.getWalletValue(), 1000);
        Assertions.assertEquals(item1.getPrice(), 34);
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4);


        userService.addItemToCart(user1, item1, 10);



        Assertions.assertEquals((int )itemRepository.itemMap.get(item1),10 );

        /*
        List<Item> li = itemService.getListOfItemsByBrand("amul");

        System.out.println("----------------list of items by brand amul---------------");
        for(Item item : li){
            System.out.println("itemPrice"+ item.getPrice()+" "+item.getCategory() );
        }

        Assertions.assertEquals(li.size(), 1);
*/

    }


}
