package com.sensesnet.lambdas.demo.ex3;

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

        //1Consumer
        Consumer<String> printer = System.out::println;
        printer.accept("Hello");

        Consumer<String> printer2 = Main::println;
        printer.accept("Hello1");

        //2 with user
        Database databaseOld = (name, surname) -> new User(name, surname);
        Database database = User::new; //передаем ссылку на конструктор
        User user = database.create("Kirill", "Sensesnet"); // тут параметры ушли в конструктор
        System.out.println(user.toString());

        //3 методы могут возвращать и ламбды
        System.out.println(getOperation('*').getResult(2, 2));
    }

    private static void println(String msg)
    {
        System.out.println(msg);
    }

    private static Operation getOperation(char symbol)
    {
        switch (symbol)
        {
            case '*':
                return (val1, val2) -> val1 * val2;
            case '+':
                return (val1, val2) -> val1 + val2;
            case '-':
                return (val1, val2) -> val1 - val2;
            default:
                return (val1, val2) -> 0;
        }
    }
}
