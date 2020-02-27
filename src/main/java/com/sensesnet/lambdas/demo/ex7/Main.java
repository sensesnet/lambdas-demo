package com.sensesnet.lambdas.demo.ex7;

import com.sensesnet.lambdas.demo.ex1.Operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * Операции сведения
 */
public class Main
{
    public static void main(String[] args)
    {
        Stream<Integer> st1 = Stream.of(-2, -1, 0, 1, 2);
//        System.out.println(st1.allMatch(num -> num >= 0));
//        System.out.println(st1.anyMatch(num -> num >= 0));
        System.out.println(st1.noneMatch(num -> num >= 0));

        Stream<Integer> st2 = Stream.of(0, 1, 2);
//        System.out.println(st2.allMatch(num -> num >= 0));
//        System.out.println(st2.anyMatch(num -> num >= 0));
        System.out.println(st2.noneMatch(num -> num >= 0));

        Stream<Integer> st3 = Stream.of(-2, -1);
//        System.out.println(st3.allMatch(num -> num > 0));
//        System.out.println(st3.anyMatch(num -> num > 0));
        System.out.println(st3.noneMatch(num -> num > 0));

        Stream<Integer> st5 = Stream.of(-2, -1, 0, 1, 2);
        System.out.println(st5.count());

        //min()  //max() + comparator
        List<Ticket> ticketList = Arrays.asList(new Ticket("Agata", 10), new Ticket("NAU", 20));

        Ticket minTicketPrice = ticketList.stream().min(Ticket::compare).get();
        System.out.printf("Min price %s: $s%d%n ", minTicketPrice.getClass(), minTicketPrice.getPrice());

        Ticket maxTicketPrice = ticketList.stream().max(Ticket::compare).get();
        System.out.printf("Max price %s: $s%d%n ", maxTicketPrice.getClass(), maxTicketPrice.getPrice());


        //Reduce бинарные операции сведения
        Stream<Integer> st6 = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> result = st6.reduce((val1, val2) -> val1 + val2);
        System.out.println(result.get());

        Stream<Integer> st7 = Stream.of(1, 2, 3, 4, 5);
        int res = st7.reduce(200, (val1, val2) -> val1 + val2);
        System.out.println(res);

        //работа с промежуточными значениями
        Stream<Integer> st8 = Stream.of(1, 2, 3, 4, 5);
        int summ = st8.reduce(0, (val1, val2) -> {
            if (val2 < 4)
            {
                return val1 + val2;
            }
            else
            {
                return val1;
            }
        }, (val1, val2) -> val1 + val2);
        System.out.println(summ);
    }
}
