package com.sensesnet.lambdas.demo.ex5;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * data stream live cycle
 * 1 create data stream
 * 2 промежутоные операции
 * 3 терминальные операции -> результат
 */
public class Main
{
    public static void main(String[] args)
    {
        Stream<String> stream = Arrays.stream(new String[] {"a","s","d"});
        stream.forEach(System.out::println);

        IntStream stream2 = Arrays.stream(new int[] {1,2,3});
        stream2.forEach(System.out::println);
        //LongStream ; DoubleStream


        // второй способ созд потоков
        Stream<String> stream3 = Stream.of("a","b","c");
        stream3.forEach(System.out::println);
        //IntStream; LongStream; DoubleStream

        //stream

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"qwe","asd","csad");
        list.stream().filter(name -> name.length() >= 2).forEach(System.out::println);
    }
}
