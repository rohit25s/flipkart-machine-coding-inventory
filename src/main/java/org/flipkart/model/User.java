package org.flipkart.model;

import lombok.Getter;

@Getter
public class User extends Account {


    private double walletValue;

    public User(String name,double walletValue){
        super(name, Role.USER);
        this.walletValue = walletValue;
    }

    public double getWalletValue() {
        return walletValue;
    }

    public void setWalletPrice(double walletValue) {
        this.walletValue = walletValue;
    }
}
