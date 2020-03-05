package com.sensesnet.lambdas.demo.ex11;

import com.sensesnet.lambdas.demo.ex6.Pizza;
import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * Sorted
 */
public class Main
{
    public static void main(String[] args)
    {

        List<CatType> catTypes = Arrays.asList(CatType.values());

        List<Cat> catsList = Arrays.asList(
                new Cat("B",12),
                new Cat("C",12),
                new Cat("D",12),
                new Cat("J",12),
                new Cat("A",12)
        );

        catTypes.sort((c1,c2) -> c1.getValue().compareTo(c2.getValue()));

//        List<Cat> result = catsList.sort((c1,c2) -> c1.getName() == catTypes.)

//        catsList.stream().flatMap(pizza -> Stream.of(String.format("Pizza: %s, price: $%d", pizza.getName(), pizza.getOld()),
//                                               String.format("Pizza: %s, price sale: $%d", pizza.getTitle(), pizza.getPrice()-2)))
//                .co;
    }
}
