package com.sensesnet.lambdas.demo.ex4;


import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * Stream api
 */
public class Main
{
    public static void main(String[] args)
    {
        int[] mass = {1, 2, 3, 4, 5, 6, 7, 8, -12};
        for (Integer el : mass)
        {
            if (el < 0) System.out.println(el + " ");
        }

        //or

        IntStream.of(mass)
                .filter(val -> val < 0)
                .forEach(System.out::println);

        //терминальные forEach- вернуд результат // промежутоные filter  - менет поток
    }

    @FunctionalInterface
    public interface TernaryIntPredicate {
        // Write a method here
        public boolean test(int a, int b, int c);
    }

    public static final TernaryIntPredicate allValuesAreDifferentPredicate =
            (a, b, c) -> java.util.stream.Stream.of(a, b, c).distinct().count() == 3;

    /**
     * The method represents a disjunct operator for a list of predicates.
     * For an empty list it returns the always false predicate.
     * Write the disjunctAll method that accepts a list of IntPredicate's and returns a single IntPredicate.
     * The result predicate is a disjunction of all input predicates.
     * If the input list is empty then the result predicate should return false for any integer value (always false).
     */
    public static IntPredicate disjunctAll(List<IntPredicate> predicates) {
        return predicates.stream().reduce(i -> false, IntPredicate::or);
    }
}
