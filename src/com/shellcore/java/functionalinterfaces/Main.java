package com.shellcore.java.functionalinterfaces;

import com.shellcore.java.functionalinterfaces.entities.Product;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Cesar. 06/06/2017.
 */
public class Main {

    public static void main(String[] args) {

        // Create a new Grocery Store List
        // Arrays.asList(): Returns a fixed-size list backed by the specific array
        // To be dynamic use LinkedList
        List<Product> groceryStore = new LinkedList<>(
                Arrays.asList(
                        new Product(0, "Tomato", "Fruit", 1.75f),
                        new Product(1, "Avocado", "Fruit", 5f),
                        new Product(2, "Lemon", "Fruit", 4.5f),
                        new Product(3, "Onion", "Vegetable", 1.50f),
                        new Product(4, "Carrot", "Vegetable", 1.25f),
                        new Product(5, "Broccoli", "Vegetable", 2f),
                        new Product(6, "Shrimp", "Seafood", 10.99f),
                        new Product(7, "Chicken", "Meat", 7.35f),
                        new Product(8, "Roast beef", "Meat", 8.35f)
                )
        );

        // Print each of the products
        System.out.println("Original list:");
        groceryStore.forEach(product -> System.out.println(product));
        System.out.println();



        // Predicate filter of meat category
        Predicate<Product> meatRemover =
                (Product product) -> "Meat".equals(product.getCategory());

        // Remove meat categories
        groceryStore.removeIf(meatRemover);
        System.out.println("Without Meat Category:");
        groceryStore.forEach(product -> System.out.println(product));
        System.out.println();



        // Predicate filter for expensive products
        Predicate<Product> expensiveRemover =
                (Product product) -> product.getPrice() > 5f;

        // Remove expensive products
        groceryStore.removeIf(expensiveRemover);
        System.out.println("Without expensive products and meat category:");
        groceryStore.forEach(product -> System.out.println(product));
        System.out.println();



        // Just filter first fruit without eliminating the other products
        System.out.println("Filter first fruit:");
        System.out.println(
                groceryStore.stream()
                        .filter(
                                (Product product) -> product.getCategory().equals("Fruit")
                        )
                        .findFirst()
        );
        System.out.println();



        // Filter fruit new list
        System.out.println("Filter all fruits:");
        System.out.println(
                groceryStore.stream()
                        .filter(
                                (Product product) -> product.getCategory().equals("Fruit")
                        )
                        .collect(Collectors.toList())
        );
        System.out.println();



        // Print each of the products
        System.out.println("Don't eliminate the other products, just filter:");
        groceryStore.forEach(product -> System.out.println(product));
    }
}
