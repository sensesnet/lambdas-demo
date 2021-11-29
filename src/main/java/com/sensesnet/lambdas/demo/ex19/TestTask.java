package com.sensesnet.lambdas.demo.ex19;

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


        Function<IntUnaryOperator, IntBinaryOperator> sumF =
                (fa) -> (a, b) -> fa.applyAsInt(a) + fa.applyAsInt(b);

        // build a new sumOfSquares operator in terms of sumF
        IntBinaryOperator sumOfSquares = sumF.apply(x -> x * x);

        // the sum is equal to 125 again
        long sum = sumOfSquares.applyAsInt(5, 10);

    }
}
