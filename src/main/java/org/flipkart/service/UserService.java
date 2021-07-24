package org.flipkart.service;

import org.flipkart.exceptions.ItemNotFoundException;
import org.flipkart.exceptions.QuantityExceedsException;
import org.flipkart.exceptions.UserNotFoundException;
import org.flipkart.model.Item;
import org.flipkart.model.User;
import org.flipkart.repository.ItemRepository;
import org.flipkart.repository.UserRepository;

public class UserService {

    ItemRepository itemRepository;
    UserRepository userRepository;

    public UserService(ItemRepository itemRepository, UserRepository userRepository){
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        userRepository.addUserToRepository(user);
        System.out.println("user added"+ user.getWalletValue());
    }

    public void addItemToCart(User user, Item item, int quantity){
        try {

            itemRepository.reduceQuantity(item, quantity);
            userRepository.addItemToCart(user,item, quantity);
        } catch (ItemNotFoundException e){
            System.out.println(e.getMessage());
        } catch (QuantityExceedsException e){
            System.out.println(e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


}
