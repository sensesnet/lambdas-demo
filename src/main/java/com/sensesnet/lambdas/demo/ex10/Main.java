package com.sensesnet.lambdas.demo.ex10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * Группировка данных
 */
public class Main
{
    public static void main(String[] args)
    {
        Stream<Computer> stream = Stream.of(
                new Computer("a", "comp_1", 10),
                new Computer("b", "comp_2", 20),
                new Computer("a", "comp_3", 30),
                new Computer("d", "comp_4", 40),
                new Computer("e", "comp_5", 50),
                new Computer("e", "comp_6", 60)
        );

        // группировка по цене

        Map<Boolean, List<Computer>> computers = stream.collect(Collectors.partitioningBy(c -> c.getPrice() > 30));

        for (Map.Entry<Boolean, List<Computer>> computer : computers.entrySet())
        {
            // true / false
            if (computer.getKey())
            {
                showProducts("more", computer);
            }
            else
            {
                showProducts("less", computer);
            }
        }


        // группировка по типу

        Stream<Computer> stream2 = Stream.of(
                new Computer("a", "comp_1", 10),
                new Computer("b", "comp_2", 20),
                new Computer("a", "comp_3", 30),
                new Computer("d", "comp_4", 40),
                new Computer("e", "comp_5", 50),
                new Computer("e", "comp_6", 60)
        );

        Map<String, List<Computer>> computersType = stream2.collect(Collectors.groupingBy(Computer::getType));

        for (Map.Entry<String, List<Computer>> item : computersType.entrySet())
        {
            System.out.println("Type:" + item.getKey());

            for (Computer c : item.getValue())
            {
                System.out.printf("Company %s; Value %d %n", c.getCompany(), c.getPrice());
            }
            System.out.println();
        }



//        Группировка с подсчетом

        Stream<Computer> stream3 = Stream.of(
                new Computer("a", "comp_1", 10),
                new Computer("b", "comp_2", 20),
                new Computer("a", "comp_3", 30),
                new Computer("d", "comp_4", 40),
                new Computer("e", "comp_5", 50),
                new Computer("e", "comp_6", 60)
        );

        Map<String, Long> computersType2 = stream3.collect(Collectors.groupingBy(Computer::getType, Collectors.counting()));

        for (Map.Entry<String, Long> item : computersType2.entrySet())
        {

                System.out.printf("Total value of computers %s; value: %d %n", item.getKey(), item.getValue());

        }
        System.out.println();

//        общая стоимость по типам (int; Long; Double)

        Stream<Computer> stream4 = Stream.of(
                new Computer("a", "comp_1", 10),
                new Computer("b", "comp_2", 20),
                new Computer("a", "comp_3", 30),
                new Computer("d", "comp_4", 40),
                new Computer("e", "comp_5", 50),
                new Computer("e", "comp_6", 60)
        );

        Map<String, Integer> computersType3 = stream4.collect(
                Collectors.groupingBy(Computer::getType, Collectors.summingInt(Computer::getPrice)));

        for (Map.Entry<String, Integer> item : computersType3.entrySet())
        {

            System.out.printf("Total value of computers %s; value: %d %n", item.getKey(), item.getValue());

        }
        System.out.println();



        //        общая стоимость по типам (int; Long; Double)

        Stream<Computer> stream5 = Stream.of(
                new Computer("a", "comp_1", 11),
                new Computer("b", "comp_2", 20),
                new Computer("a", "comp_3", 30),
                new Computer("d", "comp_4", 40),
                new Computer("e", "comp_5", 50),
                new Computer("e", "comp_6", 60)
        );
        Map<String, IntSummaryStatistics> price = stream5.collect(
                Collectors.groupingBy(Computer::getType, Collectors.summarizingInt(Computer::getPrice)));

        for (Map.Entry<String, IntSummaryStatistics> item : price.entrySet())
        {

            System.out.printf("Value of computers %s; value: %d %n", item.getKey(), item.getValue().getCount()); // min max summ average
            System.out.printf("Total Min of computers %s; value: %d %n", item.getKey(), item.getValue().getMin());
            System.out.printf("Total Max of computers %s; value: %d %n", item.getKey(), item.getValue().getMax());
        }

        System.out.println();


        //поиск большего меньшего minBy maxBy по группам
        //        общая стоимость по типам (int; Long; Double)

        Stream<Computer> stream6 = Stream.of(
                new Computer("a", "comp_1", 11),
                new Computer("b", "comp_2", 234),
                new Computer("a", "comp_3", 30),
                new Computer("d", "comp_4", 40),
                new Computer("e", "comp_5", 50),
                new Computer("e", "comp_6", 60)
        );

        Map<String, Optional<Computer>> pc = stream6.collect(
                Collectors.groupingBy(Computer::getType, Collectors.maxBy(Comparator.comparing(Computer::getPrice))));

        for (Map.Entry<String, Optional<Computer>> item : pc.entrySet())
        {
            System.out.printf("Max value of computers %s; value: %s %n", item.getKey(), item.getValue().get().getCompany());
        }
        System.out.println();



        //mapping приведение данных к другому типу

        Stream<Computer> stream7 = Stream.of(
                new Computer("a", "comp_1", 11),
                new Computer("b", "comp_2", 234),
                new Computer("a", "comp_3", 30),
                new Computer("d", "comp_4", 2340),
                new Computer("e", "comp_5", 50),
                new Computer("e", "comp_6", 60)
        );

        Map<String, List<String>> companies = stream7.collect(
                Collectors.groupingBy(Computer::getType, Collectors.mapping(Computer::getCompany, Collectors.toList())));

        for (Map.Entry<String, List<String>> item : companies.entrySet())
        {
            System.out.println(item.getKey());
            for(String type:item.getValue()){
                System.out.println(type);
            }
            System.out.println();

        }
    }

    private static void showProducts(String status, Map.Entry<Boolean, List<Computer>> item)
    {
        System.out.printf("Price is %s than $30: %n", status);

        for (Computer c : item.getValue())
        {
            System.out.printf("Type: %s, Company: %s %n", c.getType(), c.getCompany());
        }
        System.out.println();
    }
}
