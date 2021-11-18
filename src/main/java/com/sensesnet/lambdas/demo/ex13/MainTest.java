package com.sensesnet.lambdas.demo.ex13;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class MainTest {

    private static boolean isPrime(int number) {
        IntPredicate isDivisible = index -> number % index == 0;
        return number > 1 && IntStream.range(2, number - 1).noneMatch(isDivisible);
    }

    public static void main(String[] args) {
        //find prime numbers
        Integer[] numbers = {3, 6, 14, 2, 7, 42, 15, 19};
        List<Integer> testList = Arrays.asList(numbers);
        IntPredicate isPrime = MainTest::isPrime;
        // print all odd values and even values that can be divided by 3.

        //case 1
        testList.forEach(number -> {
            if (isPrime(number)) System.out.println(number);
        });

        //case 2
        testList.forEach(val -> {
            if (isPrime.test(val))
                System.out.println(val);
        });
    }
}
