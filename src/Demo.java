import pizzeria.*;
import view.ConsoleView;

import java.util.Random;

public class Demo
{
    public static void main(String[] args)
    {
        // vue console
        ConsoleView view = new ConsoleView();

        // pizzeria
        Pizzeria pizzeria = new Pizzeria();

        // pizzaiolo
        Pizzaiolo pizzaiolo = new Pizzaiolo(pizzeria);
        pizzaiolo.addListener(view);
        Thread threadPizzaolo = new Thread(pizzaiolo);
        threadPizzaolo.start();

        // client
        while(true)
        {
            wait(1000);
            if(pizzeria.getPlaces().size() < pizzeria.getPlaceDispo() && new Random().nextInt(10) == 9)
            {
                Client client = new Client(pizzeria);
                client.addListener(view);
                Thread threadClient = new Thread(client);
                threadClient.start();
            }
        }

        /*// client2
        Client client2 = new Client(pizzeria);
        client2.addListener(view);
        Thread threadClient2 = new Thread(client2);
        threadClient2.start();*/
    }

    private static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
