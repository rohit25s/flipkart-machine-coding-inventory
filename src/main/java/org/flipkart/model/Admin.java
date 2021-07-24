package org.flipkart.model;

import lombok.Getter;

@Getter
public class Admin extends Account {

    public Admin(String name){
        super(name, Role.ADMIN);
    }
}
