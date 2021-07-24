package org.flipkart.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Account {
String id;
String name;
Role role;

   public Account(String name, Role role){
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.role = role;
}

}
