package com.sensesnet.lambdas.demo.ex11;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * TODO: add description
 */
public enum CatType
{

    A("a",1),
    B("b",2),
    C("c",3),
    D("d",4),
    E("e",5),
    J("j",6);

    private String name;
    private Integer value;

    CatType(String name, Integer value)
    {
        this.name = name;
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public Integer getValue()
    {
        return value;
    }
}
