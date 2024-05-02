package org.javaalgorithminterview.ch21_greedy_algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {

    static class Cargo {
        int price;
        int weight;
        float unitPrice;

        public Cargo(int price, int weight) {
            this.price = price;
            this.weight = weight;
        }

        public void setUnitPrice(float unitPrice) {
            this.unitPrice = unitPrice;
        }
    }

    public static void main(String[] args) {
        List<Cargo> cargo = new ArrayList<>();
        cargo.add(new Cargo(4, 12));
        cargo.add(new Cargo(2, 1));
        cargo.add(new Cargo(10, 4));
        cargo.add(new Cargo(1, 1));
        cargo.add(new Cargo(2, 2));

        float optimized = fractionalKnapsack(cargo);
        System.out.println(optimized);
    }

    public static float fractionalKnapsack(List<Cargo> cargo) {
        int capacity = 15;
        float value = 0;

        // Calculate each unit price of cargos
        for (Cargo c : cargo) {
            c.setUnitPrice((float) c.price / c.weight);
        }

        // Sort the cargo list in descending order of a unit price
        cargo.sort(Comparator.comparingDouble(c -> -c.unitPrice));

        for (Cargo c : cargo) {
            if (capacity > c.weight) {
                capacity -= c.weight;
                value += c.price;
            } else {
                float fraction = (float) capacity / c.weight;
                value += c.price * fraction;
            }
        }

        return value;
    }
}
