package com.sensesnet.lambdas.demo.ex11;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * TODO: add description
 */
public class Cat
{
    private String name;
    private Integer old;

    public Cat(String name, Integer old)
    {
        this.name = name;
        this.old = old;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getOld()
    {
        return old;
    }

    public void setOld(Integer old)
    {
        this.old = old;
    }
}
