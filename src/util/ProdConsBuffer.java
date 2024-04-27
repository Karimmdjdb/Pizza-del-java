package util;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ProdConsBuffer implements ProdCons
{
    private final LinkedList<Message> buffer = new LinkedList<>();
    private int n = 0, tot=0;

    @Override
    public void put(Message m) throws InterruptedException
    {
        buffer.add(m);
        n++;
        tot++;
    }

    @Override
    public Message get() throws InterruptedException
    {
        n--;
        return buffer.removeFirst();
    }

    public Message peek() throws InterruptedException
    {
        try
        {
            return buffer.getFirst();
        }
        catch (NoSuchElementException ex)
        {
            return null;
        }
    }

    @Override
    public int nmsg()
    {
        return n;
    }

    @Override
    public int totmsg()
    {
        return tot;
    }

    public LinkedList<Message> getget()
    {
        return buffer;
    }
}
