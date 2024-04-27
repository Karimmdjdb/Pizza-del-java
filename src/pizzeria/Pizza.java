package pizzeria;

import util.Message;

public class Pizza implements Message
{
    private int idClient;
    public Pizza(int idClient)
    {
        this.idClient = idClient;
    }

    public int getId()
    {
        return idClient;
    }
}
