package pizzeria;

import util.ProdConsBuffer;
import java.util.List;
import java.util.ArrayList;

public class Pizzeria
{
    private ProdConsBuffer commandes, pizzas;
    private int places_dispo = 10;
    private List<Client> places;

    public Pizzeria()
    {
        commandes = new ProdConsBuffer();
        pizzas = new ProdConsBuffer();
        places = new ArrayList<>();
    }

    public ProdConsBuffer getCommandes()
    {
        return commandes;
    }

    public ProdConsBuffer getPizzas()
    {
        return pizzas;
    }

    public int getPlaceDispo()
    {
        return places_dispo;
    }
    public List<Client> getPlaces()
    {
        return places;
    }

    public void addClient(Client c)
    {
        places.add(c);
    }

    public void removeClient(Client c)
    {
        places.remove(c);
    }
}
