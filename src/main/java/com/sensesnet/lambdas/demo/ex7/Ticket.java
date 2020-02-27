package com.sensesnet.lambdas.demo.ex7;

/**
 * @author sensesnet <br />
 * Copyright 2020 Eshted LLC. All rights reserved.
 * <p>
 * TODO: add description
 */
public class Ticket
{
    private String title;
    private int price;

    public Ticket(String title, int price)
    {
        this.title = title;
        this.price = price;
    }

    public String getTitle()
    {
        return title;
    }

    public int getPrice()
    {
        return price;
    }

    public static int compare(Ticket a, Ticket b)
    {
        if (a.getPrice() > b.getPrice())
            return 1;
        return -1;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;

        Ticket ticket = (Ticket) o;

        if (getPrice() != ticket.getPrice()) return false;
        return getTitle() != null ? getTitle().equals(ticket.getTitle()) : ticket.getTitle() == null;

    }

    @Override
    public int hashCode()
    {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + getPrice();
        return result;
    }
}
