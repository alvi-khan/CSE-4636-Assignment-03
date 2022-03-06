package com.example.lab03_assignment;

import java.io.*;
import java.util.HashMap;

public class CartBean implements Serializable {
    public HashMap<Integer, Integer> items = new HashMap<>();
    int total = 0;

    public void addItem(Item item) {
        int value = items.getOrDefault(item.id, 0);
        items.put(item.id, value + 1);
        total += 1;
    }

    public void removeItem(Item item) {
        int value = items.get(item.id);
        if (value == 1) items.remove(item.id);
        else    items.put(item.id, value - 1);
        total -= 1;
    }

    public int getTotal() {
        return total;
    }

    public CartBean() {

    }
}