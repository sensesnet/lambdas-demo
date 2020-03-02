package com.sensesnet.lambdas.demo.ex10;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
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
                new Computer("c", "comp_3", 30),
                new Computer("d", "comp_4", 40),
                new Computer("e", "comp_5", 50),
                new Computer("j", "comp_6", 60)
        );


        Map<Boolean, List<Computer>> computers = stream.collect(Collectors.partitioningBy(c -> c.getPrice() > 30));

        for (Map.Entry<Boolean, List<Computer>> computer : computers.entrySet())
        {
            if (computer.getKey())
            {
                showProducts("more", computer);
            }
            else
            {
                showProducts("less", computer);
            }
        }
    }

    private static void showProducts(String status, Map.Entry<Boolean, List<Computer>> item)
    {
        System.out.printf("Price is %s than $1000: %n", status);

        for (Computer c : item.getValue())
        {
            System.out.printf("Type: %s, Company: %s %n", c.getType(), c.getCompany());
        }
        System.out.println();
    }
}
