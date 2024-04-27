package view;

import pizzeria.Client;
import pizzeria.Pizzaiolo;

public class ConsoleView implements util.Listener
{
    @Override
    public synchronized void update(Object source)
    {
        if(source instanceof Pizzaiolo pizzaiolo)
        {
            switch (pizzaiolo.getState())
            {
                case Pizzaiolo.PREPARING:
                    System.out.println("Le pizzaiolo prépare la commande du client n°" + pizzaiolo.getCommandId());
                    break;
                case Pizzaiolo.DELIVERING:
                    System.out.println("Le pizzaiolo a terminé la préparation la commande du client n°" + pizzaiolo.getCommandId());
                    break;
            }
        }
        else if(source instanceof Client client)
        {
            switch (client.getState())
            {
                case Client.ENTERED:
                    System.out.println("Un nouveau client (" + client.getId() + ") est entré dans la pizzeria.");
                    break;
                case Client.ORDERED:
                    System.out.println("Le client n°" + client.getId() + " a commandé une pizza.");
                    break;
                case Client.EATING:
                    System.out.println("Le client n°" + client.getId() + " mange sa pizza.");
                    break;
                case Client.PAYED:
                    System.out.println("Le client n°" + client.getId() + " a payé et s'en va de la pizzeria.");
                    break;
            }
        }
    }
}
