package com.sm.model;

import java.math.BigDecimal;

public class Customer {
    private String name;
    private String membership;
    private int discount;
    private boolean newCustomer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(boolean newCustomer) {
        this.newCustomer = newCustomer;
    }
}