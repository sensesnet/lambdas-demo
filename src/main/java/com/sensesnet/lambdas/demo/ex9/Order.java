package com.sensesnet.lambdas.demo.ex9;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * TODO: add description
 */
public class Order
{
    private int id;
    private String context;

    public Order(int id, String context)
    {
        this.id = id;
        this.context = context;
    }

    public int getId()
    {
        return id;
    }

    public String getContext()
    {
        return context;
    }
}
