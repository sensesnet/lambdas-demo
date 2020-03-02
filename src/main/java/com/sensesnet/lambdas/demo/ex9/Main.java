package com.sensesnet.lambdas.demo.ex9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * приведение потока данных к коллекции
 */
public class Main
{
    public static void main(String[] args)
    {
        // приведение к List
        Stream<String> values = Stream.of("a", "c", "as", "yhg", "ty");
        values.collect(Collectors.toList()).forEach(System.out::println);

        //приведение к set
        Stream<String> values2 = Stream.of("a", "c", "as", "yhg", "ty");
        values2.collect(Collectors.toSet()).forEach(System.out::println);


        //приведение к определенной коллекции
        Stream<String> values3 = Stream.of("a", "c", "as", "yhg", "ty");
        values3.collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);


        // to Map (key, value)
        Stream<Order> order = Stream.of(new Order(1, "a"), new Order(2, "b"));
        order.collect(Collectors.toMap(Order::getId, Order::getContext))
                .forEach((key, value) -> System.out.printf("Key: %d, value: %s %n", key, value));

        //
        Stream<String> values4 = Stream.of("v1", "v2", "v3", "v4", "v5");
        values4.collect(ArrayList::new, ArrayList::add, ArrayList::addAll).forEach(System.out::println);
    }
}
