package util;

import java.util.List;
import java.util.ArrayList;
public class AbstractModel implements Model
{
    private List<Listener> listeners = new ArrayList<Listener>();

    public void fireChangement()
    {
        for(Listener listener : listeners)
        {
            listener.update(this);
        }
    }

    @Override
    public void addListener(Listener listener)
    {
        listeners.add(listener);
    }

    @Override
    public void removeListener(Listener listener)
    {
        listeners.remove(listener);
    }
}
