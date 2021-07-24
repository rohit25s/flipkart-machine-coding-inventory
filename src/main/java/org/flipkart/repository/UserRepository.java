package org.flipkart.repository;

import org.flipkart.exceptions.ItemNotFoundException;
import org.flipkart.exceptions.UserNotFoundException;
import org.flipkart.model.Item;
import org.flipkart.model.User;

import java.util.*;

public class UserRepository {
    public Map<User, List<Item>> cart;
    Set<User> users;

    public UserRepository(){
        cart = new HashMap<>();
        users = new HashSet<>();
    }

    public void addUserToRepository(User user){
        if(!users.contains(user))
            users.add(user);
        cart.putIfAbsent(user, new ArrayList<>());
    }

    public void addItemToCart(User user, Item item, int quantity) throws UserNotFoundException, ItemNotFoundException{
        if(cart.get(user)==null)
            throw new UserNotFoundException("User not found.");

        double wallet =user.getWalletValue();

        System.out.println("intial"+wallet+" item:"+item.getPrice());
        user.setWalletPrice(wallet-quantity*item.getPrice());
        cart.get(user).add(item);
    }

}
