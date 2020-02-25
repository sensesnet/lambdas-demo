package com.sensesnet.lambdas.demo.ex4;


import java.util.stream.IntStream;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * Stream api
 */
public class Main
{
    public static void main(String[] args)
    {
        int[] mass = {1, 2, 3, 4, 5, 6, 7, 8, -12};
        for (Integer el : mass)
        {
            if (el < 0) System.out.println(el + " ");
        }

        //or

        IntStream.of(mass)
                .filter(val -> val < 0)
                .forEach(System.out::println);

        //терминальные forEach- вернуд результат // промежутоные filter  - менет поток
    }
}
