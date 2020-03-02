package com.sensesnet.lambdas.demo.ex8;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
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
        Stream<Integer> stream = Stream.of(); //-1,0,1
        Optional<Integer> result = stream.min(Integer::compare);
        //if(result.isPresent()) System.out.println(result.get());
        result.ifPresent(System.out::println);

//        result.ifPresentOrElse(System.out::println, () -> System.out.println("Stream element is not found."));

        System.out.println(result.orElseGet(()->new Random().nextInt(100)));

        // если optional не имеет значение генерируем exception
        System.out.println(result.orElseThrow(RuntimeException::new));
    }
}
