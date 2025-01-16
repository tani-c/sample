package org.example;

public class StringCalculator {
    public int add(String numbers) {
        int sum = 0;

        if (numbers == null || numbers.isEmpty()) {
            return sum;
        }

        String[] values = numbers.split(",|\n");

        for (String value : values) {
            int num = Integer.parseInt(value.trim());
            sum += num;
        }
        return sum;
    }
}
