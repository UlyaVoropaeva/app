package com.example.app;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();

    private final List<Product> products = new ArrayList<>();
    private final AtomicInteger counter = new AtomicInteger(1);

    public static Model getInstance() {
        return instance;
    }

    @PostConstruct
    private void productsList() {

        products.add(new Product(counter.getAndIncrement(), "Apple", 10));
        products.add(new Product(counter.getAndIncrement(), "Tomato", 20));
        products.add(new Product(counter.getAndIncrement(), "Cucumber", 15));
        products.add(new Product(counter.getAndIncrement(), "Potato", 18));
        products.add(new Product(counter.getAndIncrement(), "Raspberry", 30));
        products.add(new Product(counter.getAndIncrement(), "L", 10));
        products.add(new Product(counter.getAndIncrement(), "Cocos", 20));
        products.add(new Product(counter.getAndIncrement(), "C", 15));
        products.add(new Product(counter.getAndIncrement(), "P", 18));
        products.add(new Product(counter.getAndIncrement(), "Ry", 30));
    }


    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Product product : products) {
            builder.append(product.getId());
            builder.append(" - ");
            builder.append(product.getName());
            builder.append(" - ");
            builder.append(product.getPrice());
            builder.append(" money\n");
        }

        return builder.toString();
    }

}
