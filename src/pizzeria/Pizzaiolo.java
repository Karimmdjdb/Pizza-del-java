package pizzeria;
import java.lang.Runnable;

public class Pizzaiolo extends util.AbstractModel implements Runnable
{
    public final static int IDLE = 0, PREPARING = 1, DELIVERING = 2;
    private final Pizzeria pizzeria;
    private Commande commande;
    private int state;
    public Pizzaiolo(Pizzeria pizzeria)
    {
        state = IDLE;
        this.pizzeria = pizzeria;
    }
    private static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            System.out.println(ex.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public void run()
    {
        while(true)
        {
            if(pizzeria.getCommandes().nmsg() > 0)
            {
                preparerCommande();
            }
            wait(1000);
        }
    }

    public int getCommandId()
    {
        return commande.getNumeroCommande();
    }

    private void preparerCommande()
    {
        try
        {
            synchronized (pizzeria.getCommandes())
            {
                commande = (Commande) pizzeria.getCommandes().get();
                state = PREPARING;
                fireChangement();
                wait(10000);
                Pizza pizza = new Pizza(commande.getNumeroCommande());
                pizzeria.getPizzas().put(pizza);
                state = DELIVERING;
                fireChangement();
            }
        }
        catch (InterruptedException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public int getState()
    {
        return state;
    }
}
