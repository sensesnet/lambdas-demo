package com.sensesnet.lambdas.demo.ex10;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * TODO: add description
 */
public class Computer
{
    private String type;
    private String company;
    private Integer price;

    public Computer(String type, String company, Integer price)
    {
        this.type = type;
        this.company = company;
        this.price = price;
    }

    public String getType()
    {
        return type;
    }

    public String getCompany()
    {
        return company;
    }

    public Integer getPrice()
    {
        return price;
    }
}
