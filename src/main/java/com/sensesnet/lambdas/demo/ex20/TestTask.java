package com.sensesnet.lambdas.demo.ex20;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

/*
 In this problem, you need to complete the implementations of two functions.

The reduceIntOperator that accepts an initial value (seed) and a combiner function and returns
a new function that combines all values from the given integer range into a single integer value
(it's a simple form of reduction) using a given operator. The seed is used as the very first element in reducing.
Based on reduceIntOperator, implement the productOperator operator that multiplies integer values in the range.

There is also an example: the sumOperator that is based on reduceIntOperator. It uses 0 as the seed value and
the function x + y and just sums numbers in the range.

Let's take a look at two example of how the operators should work. The left boundary <= the right boundary.
 */
public class TestTask {

    /**
     * The operator combines all values in the given range into one value
     * using combiner and initial value (seed)
     */
    public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator =
            (seed, combiner) -> (x, y) -> {
                int acc = seed;
                for (int i = x; i <= y; i++) {
                    acc = combiner.applyAsInt(acc, i);
                }
                return acc;
            };

    /**
     * The operator calculates the sum in the given range (inclusively)
     */
    public static final IntBinaryOperator sumOperator = reduceIntOperator.apply(0, (x, y) -> x + y);

    /**
     * The operator calculates the product in the given range (inclusively)
     */
    public static final IntBinaryOperator productOperator = reduceIntOperator.apply(1, (x, y) -> x * y);

    public static void main(String[] args) {
        //15
        IntBinaryOperator sum = (x, y) -> x + y;
        IntBinaryOperator resultWithSumOperator = reduceIntOperator.apply(5, sum);
        System.out.println(resultWithSumOperator.applyAsInt(1, 4));

        // 120 = 5 * (1 * 2 * 3 * 4)
        IntBinaryOperator multiply = (x, y) -> x * y;
        IntBinaryOperator resultWitMultiplyOperator = reduceIntOperator.apply(5, multiply);
        System.out.println(resultWitMultiplyOperator.applyAsInt(1, 4));

        // 60 = 2 * (5 * 6)
        IntBinaryOperator multiply1 = (x, y) -> x * y;
        IntBinaryOperator resultWitMultiplyOperator1 = reduceIntOperator.apply(2, multiply);
        System.out.println(resultWitMultiplyOperator.applyAsInt(5, 6));

        // 11 = 5 + 6
        System.out.println(sumOperator.applyAsInt(5, 6));
        // 30 = 5 * 6
        System.out.println(productOperator.applyAsInt(5, 6));
    }


    public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator2 =
            (seed, ibo) -> (l, r) -> IntStream.rangeClosed(l, r).reduce(seed, ibo);
    /**
     * The operator calculates the sum in the given range (inclusively)
     */
    public static final IntBinaryOperator sumOperator2 = reduceIntOperator2.apply(0, Integer::sum);

    /**
     * The operator calculates the product in the given range (inclusively)
     */
    public static final IntBinaryOperator productOperator2 = reduceIntOperator2.apply(1, (a, b) -> a*b);

}
