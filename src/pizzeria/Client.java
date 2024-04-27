package pizzeria;

import util.Message;

public class Client extends util.AbstractModel implements Runnable
{
    public final static int NEW=0, ENTERED=1, ORDERED=2, EATING=3, PAYED=4;
    private static int count = 0, totCount = 0;
    private int state, id;
    private Pizzeria pizzeria;

    public Client(Pizzeria pizzeria)
    {
        this.pizzeria = pizzeria;
        this.pizzeria.addClient(this);
        state = NEW;
        count++;
        totCount++;
        id = count;
    }

    public void changeState(int newState)
    {
        state = newState;
        fireChangement();
    }

    public int getState()
    {
        return state;
    }

    public int getId()
    {
        return id;
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

    @Override
    public void run()
    {
        while(true)
        {
            wait(2000);
            if(state == NEW)
            {
                changeState(ENTERED);
                continue;
            }
            if(state == ENTERED)
            {
                commander();
                continue;
            }
            if(state == ORDERED)
            {
                manger();
                continue;
            }
            if(state == PAYED)
            {
                pizzeria.removeClient(this);
                break;
            }
        }
    }

    private void commander()
    {
        try
        {
            synchronized (pizzeria.getCommandes())
            {
                pizzeria.getCommandes().put(new Commande(getId()));
            }
            changeState(ORDERED);
        }
        catch (InterruptedException ignored)
        {

        }
    }

    private void manger()
    {
        synchronized (pizzeria.getPizzas())
        {
            try
            {
                Pizza pizza = (Pizza)pizzeria.getPizzas().peek();
                if(pizza != null && pizza.getId() == id)
                {
                    pizzeria.getPizzas().get();
                    changeState(EATING);
                    wait(10000);
                    changeState(PAYED);
                }
            }
            catch (InterruptedException ex)
            {

            }
        }
    }

}
