package com.sensesnet.lambdas.demo.ex15;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        boolean result = LongStream
                .rangeClosed(1, 100_000)
                .anyMatch(val -> val == 100_000);

        System.out.println(result);

        boolean result2 = !IntStream
                .generate(() -> 100)
                .limit(101)
                .allMatch(val -> val >= 100);

        System.out.println(result2);

        boolean result3 = IntStream
                .iterate(0, n -> n + 1)
                .limit(100)
                .filter(n -> n % 2 != 0)
                .noneMatch(n -> n % 2 == 0);

        System.out.println(result3);


    }


    /*
     Write a method using Stream API to check the input number is prime or not.
     Let's agree that input value is always greater than 1 (i.e. 2, 3, 4, 5, ....). Use the provided template for your method.
     A prime number is a value greater than 1 that has no positive divisors other than 1 and itself. See https://en.wikipedia.org/wiki/Prime_number
     Important. This problem has a simple and clear solution with streams. Please, do not use cycles.
     */

    public static boolean isPrime(final long number) {
        // write your code here
        LongPredicate isDivisible = index -> number % index == 0;
        return number > 1 && LongStream.range(2, number - 1).noneMatch(isDivisible);
    }

    /*
    Create a stream that will detect bad words in a text according to a bad words list.
    All words in the text are divided by whitespaces (always only one whitespace between two words).
    After calling collect(Collectors.toList()) the stream must return the list of bad words which were found in the text.
    The result should be dictionary ordered (in lexicographical order, i.e. sorted) and bad words shouldn't repeat.
    Important. You need return a prepared stream from the template method, not a list of bad words.
    Pay attention to the method template. Do not change it!
     */
    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        return Arrays.stream(text.split(" "))
                .distinct()
                .filter(x -> badWords.stream().anyMatch(y -> x.equals(y)))
                .sorted();
//        return Arrays.stream(text.split("\\s"))
//                .filter(badWords::contains)
//                .sorted()
//                .distinct();
    }

    /*
    You have two IntStream. The first stream contains even numbers and the second stream contains odd numbers.
    Create the third stream that contains numbers from both streams which is divisible by 3 and 5.
    After calling collect(Collectors.toList()) the stream should return sorted list (ascending) of these numbers.
    Two first suitable numbers in the sorted list must be skipped.
    Important. You need return a prepared IntStream from a template method, not a list of integers.
    Pay attention to the method template. Do not change the signature of this method.
     */
    public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
        return IntStream.concat(evenStream, oddStream)
                .distinct()
                .filter(x -> x % 3 == 0 & x % 5 == 0)
                .sorted()
                .skip(2);
    }

}
