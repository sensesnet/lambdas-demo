package com.sensesnet.lambdas.demo.ex18;

import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestMain {
    public static void main(String[] args) {

        //parallel ad 100 in each stream
        int result = Stream.of(5, 10, 20, 50).parallel().reduce(100, Integer::sum);
        int result2 = Stream.of(5, 10, 20, 50).sequential().reduce(100, Integer::sum);
        int result3 = Stream.of(5, 10, 20, 50).reduce(100, Integer::sum);

        System.out.println(result + " " + result2 + " " + result3);

        // build a new sumOfSquares operator
        IntBinaryOperator sumOfSquares = sumF(x -> x * x);

        // the sum is equal to 125
        long sum = sumOfSquares.applyAsInt(5, 10);

        // sum of two identities: 0 + 10 = 10
        long sumOfIdentities = sumF(x -> x).applyAsInt(0, 10);

        // sum with coefficients: 10 * 2 + 11 * 2 = 42
        long sumWithCoefficient = sumF(x -> x * 2).applyAsInt(10, 11);

        // sum of two cubes: 3 * 3 * 3 + 8 * 8 * 8 = 539
        long sumOfCubes = sumF(x -> x * x * x).applyAsInt(3, 8);
    }

    public static IntBinaryOperator sumF(IntUnaryOperator f) {
        return (a, b) -> f.applyAsInt(a) + f.applyAsInt(b);
    }


    /*
           Create a parallel LongStream for filtering prime numbers in the given range (inclusively).
           The static method NumberUtils.isPrime(...some long number...) will be available for you during testing.
           It returns true if the passed value is prime and false otherwise.
           Be carefully with rangeClose(d), iterate and limit methods!
           Important. You need return a prepared parallel stream from the template.
           After calling count() it should return the count of prime numbers in the given range. Pay attention to the method template. Do not change it.
           PS: it's not a very efficient approach for generating prime numbers, it's just an example of parallel streams.
            */

//    public static LongStream createPrimesFilteringStream(long rangeBegin, long rangeEnd) {
//        return LongStream.rangeClosed(rangeBegin, rangeEnd).parallel().filter(x -> NumberUtils.isPrime(x));
//    }


}

