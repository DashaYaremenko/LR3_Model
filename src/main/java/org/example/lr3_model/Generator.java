package org.example.lr3_model;

public class Generator {
    private final long a = 1664525;  // Множник
    private final long c = 1013904223; // Константа
    private final long m = (long) Math.pow(2, 32); // Модуль
    private long seed; // Початкове значення

    public Generator(long seed) {
        this.seed = seed;
    }

    public double[] generate(int count) {
        double[] values = new double[count];
        for (int i = 0; i < count; i++) {
            seed = (a * seed + c) % m;
            values[i] = (double) seed / m * 20000;
        }
        return values;
    }
}
