package com.sensesnet.lambdas.demo.ex12;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * <p>
 * В данном примере мы рассмотрим, какие улучшения, касающиеся Stream API были сделаны в Java 9.
 * <p>
 * Мы рассмотрим следующие методы:
 * <p>
 * iterate
 * dropWhile
 * takeWhile
 * ofNullable
 */
public class Main
{
    public static void main(String[] args)
    {
        // iterate  (static  Stream iterate(T seed, Predicate<? super T> hasNext, UnaryOperator next))
        IntStream.iterate(0, i -> i < 20, i -> i + 5).forEach(System.out::println);
        System.out.println("-iterate-");

        //dropWhile (default Stream dropWhile(Predicate<? super T> predicate))
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .dropWhile(element -> element < 6)
                .forEach(System.out::println);
        System.out.println("-dropWhile-");

        //takeWhile (default Stream takeWhile(Predicate<? super T> predicate))
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .takeWhile(element -> element < 6)
                .forEach(System.out::println);
        System.out.println("-takeWhile-");

        //ofNullable (static  Stream ofNullable(T t))

        long checker = Stream.ofNullable("String").count();
        System.out.println(checker);

        checker = Stream.ofNullable(null).count();
        System.out.println(checker);
        System.out.println("-ofNullable-");
    }


}
