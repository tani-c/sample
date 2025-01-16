package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        int sum = 0;
        String delimiter = ",|\n";
        List<Integer> negativeNumbers = new ArrayList<>();

        if (numbers == null || numbers.isEmpty()) {
            return sum;
        }

        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }

        String[] values = numbers.split(delimiter);

        for (String value : values) {
            try {
                int num = Integer.parseInt(value.trim());
                if (num < 0) {
                    negativeNumbers.add(num);
                    continue;
                }
                sum += num;
            } catch (NumberFormatException e) {
                //as of now just ignoring from summation
            }
        }
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
        }

        return sum;
    }
}
