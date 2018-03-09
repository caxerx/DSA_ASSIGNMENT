/**
 * This is a data class of shop, only store the values of store. The simulation logic stored in {@link ShopSimulation} object
 */
public class Shop {
    private LinkedQueue<Integer> queue;
    private int[] counter;

    /**
     * @param counters number of counters
     */
    public Shop(int counters) {
        this.queue = new LinkedQueue<>(); //create a queue with capped size
        this.counter = new int[counters]; //create empty counters
    }

    /**
     * Get time of counters
     *
     * @param counterIndex index of counter
     * @return time of the counter
     */
    public int getCounterTime(int counterIndex) {
        return counter[counterIndex];
    }

    /**
     * Set time of a counter
     *
     * @param counterIndex index of counter
     * @param counterTime  the new time of the counter
     */
    public void setCounterTime(int counterIndex, int counterTime) {
        counter[counterIndex] = counterTime;
    }

    /**
     * Get the queue object of the shop
     *
     * @return queue of the shop
     */
    public LinkedQueue<Integer> getQueue() {
        return queue;
    }

}
