package com.tunglain;

public class SalesProduct extends Product {
    float discount = 1.0f ;

    public SalesProduct(int id, Category category, String name, int price, float discount) {
        super(id, category, name, price);
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        if (discount < 1.0f) {
            return (int) (price*discount);
        } else return price;
    }
}
