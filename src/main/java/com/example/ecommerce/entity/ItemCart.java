package com.example.ecommerce.entity;

public class ItemCart {
    private int itemid;

    public ItemCart() {
    }

    public ItemCart(int itemid) {
        this.itemid = itemid;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }
}
