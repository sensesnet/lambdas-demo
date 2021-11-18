package com.sensesnet.lambdas.demo.ex1;


import java.util.function.Function;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * TODO: add description
 */
public class Main
{
    public static void main(String[] args)
    {
        int constant = 100;
        Function<Integer, Integer> adder = x -> x + constant;

        System.out.println(adder.apply(200));
        System.out.println(adder.apply(300));

        // operations inter impl
        Operation operation = new Operation()
        {
            public Integer getSumm(Integer a, Integer b)
            {
                return a + b;
            }
        };

        System.out.println(operation.getSumm(1, 2));


        // нетерминальное лямбда выражение
        Operation lambda = (a, b) -> a + b;
        System.out.println(lambda.getSumm(2, 2));

        // пример терминального
        Printer printer = string -> System.out.println(string);
        printer.println("Hello");


        //block
        Factorial factorial = value -> {
            int result = 1;
            for (int i = 1; i < value; i++)
            {
                result *= i;
            }
            return result;
        };
        printer.println(factorial.getResult(5).toString());


        // without params

        Integer a = 1;
        Integer b = 1;

        DataInt dataInt = () -> {

            return a - b;
        };

        printer.println(dataInt.getResult().toString());
    }

}
