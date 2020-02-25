package com.sensesnet.lambdas.demo.ex3;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * User pojo
 */
public class User
{
    private String name;
    private String secondName;

    public User(String name, String secondName)
    {
        this.name = name;
        this.secondName = secondName;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSecondName()
    {
        return secondName;
    }

    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
