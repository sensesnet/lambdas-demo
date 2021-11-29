package com.sensesnet.lambdas.demo.ex19;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class TestTask {

    public static void main(String[] args) {

        // curried function
        IntFunction<IntFunction<IntFunction<Integer>>> fff = x -> y -> z -> x * y + z;

        // fff returns a curried function y -> z -> 2 * y + z
        IntFunction<IntFunction<Integer>> ff = fff.apply(2);

        // ff returns a curried function z -> 2 * 3 + z
        IntFunction<Integer> f = ff.apply(3);

        // f returns 7
        int result = f.apply(1);

        //------
        // the another result is equal to 153
        int anotherResult = fff.apply(10).apply(15).apply(3);

        //------

        Function<IntUnaryOperator, IntBinaryOperator> sumF =
                (fa) -> (a, b) -> fa.applyAsInt(a) + fa.applyAsInt(b);

        // build a new sumOfSquares operator in terms of sumF
        IntBinaryOperator sumOfSquares = sumF.apply(x -> x * x);

        // the sum is equal to 125 again
        long sum = sumOfSquares.applyAsInt(5, 10);
        //------


        //Returning functions

        // build a new sumOfSquares operator
        IntBinaryOperator sumOfSquares1 = sumF(x -> x * x);

        // the sum is equal to 125
        long sum1 = sumOfSquares1.applyAsInt(5, 10);

        //

        Function<String, Consumer<String>> say = what -> whom -> System.out.println(what + ", " + whom);

        List<String> friends = Arrays.asList("John", "Neal", "Natasha");
        Consumer<String> sayHi = say.apply("Hi");
        friends.forEach(sayHi);

        List<String> partners = Arrays.asList("Randolph Singleton", "Jessie James");
        Consumer<String> sayHello = say.apply("Hello");
        partners.forEach(sayHello);


        BiFunction<Integer, Integer, BiFunction<Integer, Integer, Function<Integer, Integer>>> aaa = (a4,a2) -> (a3,a1) -> (a5) -> a1;
        BiFunction<Integer, Integer, Function<Integer, Integer>> aa = aaa.apply(5,6);
        Function<Integer, Integer> a = aa.apply(7,8);

        int resultBiFunc = a.apply(1);

        System.out.println(resultBiFunc);
    }

    public static IntBinaryOperator sumF(IntUnaryOperator f) {
        return (a, b) -> f.applyAsInt(a) + f.applyAsInt(b);
    }
}
