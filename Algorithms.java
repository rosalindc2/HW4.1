import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Algorithms {
    private static File f;
    private static Scanner s;

    public static void main(String[] args) throws FileNotFoundException {
        f = new File("Numbers.txt");
        s = new Scanner(f); 

        List<Integer> numbers = new ArrayList<>();
        while (s.hasNext()) {
            numbers.add(s.nextInt());
        }
        s.close();  

        int odds = countOdds(numbers);
        int evens = countEvens(numbers);
        int twoDigitCount = countTwoDigitNumbers(numbers);
        int greaterThan500 = countGreaterThan500(numbers);
        int greatest = Collections.max(numbers);
        int least = Collections.min(numbers);
        int sum = sum(numbers);
        double average = average(numbers);
        int mode = mode(numbers);

        System.out.println("Odd numbers count: " + odds);
        System.out.println("Even numbers count: " + evens);
        System.out.println("Two-digit numbers count: " + twoDigitCount);
        System.out.println("Numbers greater than 500: " + greaterThan500);
        System.out.println("Greatest number: " + greatest);
        System.out.println("Least number: " + least);
        System.out.println("Sum of numbers: " + sum);
        System.out.println("Average: " + String.format("%.3f", average));
        System.out.println("Mode: " + mode);
    }

    public static int countOdds(List<Integer> numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static int countEvens(List<Integer> numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int countTwoDigitNumbers(List<Integer> numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num >= 10 && num <= 99) {
                count++;
            }
        }
        return count;
    }

    public static int countGreaterThan500(List<Integer> numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num > 500) {
                count++;
            }
        }
        return count;
    }

    public static int sum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static double average(List<Integer> numbers) {
        return (double) sum(numbers) / numbers.size();
    }

    public static int mode(List<Integer> numbers) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : numbers) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int mode = numbers.get(0);
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                mode = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mode;
    }
}
