package pizzeria;

public class Commande implements util.Message
{
    private int numeroCommande;
    public Commande(int numeroCommande)
    {
        this.numeroCommande = numeroCommande;
    }

    public int getNumeroCommande()
    {
        return numeroCommande;
    }

    @Override
    public String toString()
    {
        return "commande n"+numeroCommande;
    }
}
