package util;

public interface ProdCons
{
    /**
     * ajoute le message m au buffer de production/consommation
     * @throws InterruptedException
     */
    public void put(Message m) throws InterruptedException;

    /**
     * retroune un message du buffer de production/consommation suivant un ordre FIFO
     * @return un message
     * @throws InterruptedException
     */
    public Message get() throws InterruptedException;

    /**
     *
     * @return le nombre de messages actuellement contenus dans le buffer
     */
    public int nmsg();

    /**
     *
     * @return le nombre de messages qui ont été ajoutés au buffer depuis sa création
     */
    public int totmsg();
}
