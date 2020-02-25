package com.sensesnet.lambdas.demo.ex6;

import java.util.stream.Stream;

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
        Stream<String> stream = Stream.of("asdasd12","asdasd24","asdasd141","asdasd213");
        stream.filter(pass ->pass.length()>5).forEach(System.out::println);

        Stream<String> stream2 = Stream.of("asdasd12","asdasd24","asdasd141","asdasd213");
//        stream2.skip(2).forEach(System.out::println);


        Stream<Film> filmStream = Stream.of(new Film("Brat",10.0),new Film("Brat2",10.0));
        filmStream.map(Film::getPrise).forEach(System.out::println);

        


    }
}
