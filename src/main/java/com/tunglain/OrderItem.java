package com.tunglain;

import com.tunglain.Product;

public class OrderItem extends Product {
    int qty; //數量

    public OrderItem(Product product, int qty) {
        this(product);
        this.qty = qty;
    }

    //TODO: 作業
    public OrderItem(Product product) {
        this.id = product.id;
        this.name = product.name;
        this.price = product.price;
        qty = 1;
    }
}
