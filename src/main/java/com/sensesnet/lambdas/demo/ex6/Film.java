package com.sensesnet.lambdas.demo.ex6;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * TODO: add description
 */
public class Film
{
    private String title;
    private double prise;

    public Film(String title, double prise)
    {
        this.title = title;
        this.prise = prise;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public double getPrise()
    {
        return prise;
    }

    public void setPrise(double prise)
    {
        this.prise = prise;
    }
}
