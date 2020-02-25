package com.sensesnet.lambdas.demo.ex2;

import java.util.Objects;
import java.util.Scanner;
import java.util.function.*;

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
        //Functional interfaces
        //Custom
        Optional<Integer> optionalSumm = (a, b) -> a + b;
        Optional<String> optionalProiz = (a, b) -> a + b;

        System.out.println(optionalSumm.getResult(2,3));
        System.out.println(optionalProiz.getResult("asd","asd"));

        //Predicate
        Integer a = 136;
        Predicate<Integer> isNull = Objects::isNull;
        Predicate<Integer> isEmpty = value -> value == 0;
        System.out.println(isEmpty.test(1));
        System.out.println(isNull.test(a));

        //Consumer
        Consumer<String> printer = string -> System.out.println(string);
        printer.accept("Hello");

        //Function
        Function<Integer, Double> converter = value -> Double.valueOf(value);
        printer.accept(converter.apply(a).toString());

        //Supplier
        Supplier<String> message = () ->{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter tet: ");
            return scanner.nextLine();
        };
        printer.accept(message.get());

        //UnaryOperation
        UnaryOperator<Double> sqrt = value -> Math.sqrt(value);
        printer.accept(sqrt.apply(12.0).toString());

        //BinaryOperation
        BinaryOperator<Double> pow = (val1,val2) -> Math.pow(val1,val2);
        printer.accept(pow.apply(2.0,2.0).toString());
    }
}
