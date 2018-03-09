/**
 * Shop simulation, control the shops counter and queue in the simulation
 */
public class ShopSimulation {
    private Shop shop;
    private LinkedQueue<Integer> shopQueue;
    private int currentTime = 0;
    private int counters;
    private int simulationTime;

    private int servedCustomer = 0;
    private int maxQueue = 0;
    private int totalQueuePerUnit = 0;

    /**
     * @param counters       number of the counters
     * @param simulationTime total simulation time
     */
    public ShopSimulation(int counters, int simulationTime) {
        this.counters = counters;
        this.simulationTime = simulationTime;
        shop = new Shop(counters);
        shopQueue = shop.getQueue();
    }

    /**
     * Get the shop object in simulation
     *
     * @return shop object
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * increase a unit of time and queue a customer
     *
     * @param processTime the process time of the customer
     * @throws SimulationEndException throw when the method call after simulation end
     */
    public void timeLapse(int processTime) throws SimulationEndException {
        if (isSimulationEnd()) {
            throw new SimulationEndException();
        }
        currentTime++;
        counterOut();
        dequeueToCounter();
        enqueue(processTime);
        dequeueToCounter();
        int currentQueueSize = shopQueue.getSize();
        maxQueue = currentQueueSize > maxQueue ? currentQueueSize : maxQueue;
        totalQueuePerUnit += currentQueueSize;
    }

    /**
     * get whether the simulation end
     *
     * @return is the simulation end
     */
    public boolean isSimulationEnd() {
        return currentTime >= simulationTime;
    }


    /**
     * Add a customer into queue except the time is 0
     *
     * @param time process time of the customer
     */
    private void enqueue(int time) {
        if (time != 0) {
            shopQueue.enqueue(time);
        }
    }

    /**
     * Move a customer to counter if queue is not empty and counter is not full.
     */
    private void dequeueToCounter() {
        int emptyCounter;
        while ((emptyCounter = findEmptyCounter()) != -1 && !shopQueue.isEmpty()) {
            counterIn(emptyCounter, shopQueue.dequeue());
            servedCustomer++;
        }
    }

    /**
     * This method will find this first empty counter in all of the counters, or return -1 if all counter is full.
     *
     * @return first empty counter, or -1 if all counter is full.
     */
    private int findEmptyCounter() {
        for (int i = 0; i < counters; i++) {
            if (shop.getCounterTime(i) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Move a customer into a counter, set counter's end-of-process time
     *
     * @param counter     counter number
     * @param processTime the process time of the customer
     */
    private void counterIn(int counter, int processTime) {
        shop.setCounterTime(counter, processTime + currentTime);
    }

    /**
     * Move customers out of the counters when the process is finish
     */
    private void counterOut() {
        for (int i = 0; i < counters; i++) { //for each the counter
            //move out customer when serve time pass
            int counterTime;
            if ((counterTime = shop.getCounterTime(i)) != 0 && currentTime >= counterTime) {
                shop.setCounterTime(i, 0);
            }
        }
    }

    /**
     * get total served customer
     *
     * @return served customer
     */
    public int getServedCustomer() {
        return servedCustomer;
    }

    /**
     * get Average Waiting Line Length in simulation
     *
     * @return Average Waiting Line Length
     */
    public double getAverageQueue() {
        return totalQueuePerUnit / (double) currentTime;
    }

    /**
     * get maximum customer in queue while the simulation
     *
     * @return Maximum Waiting Line Length
     */
    public int getMaxQueue() {
        return maxQueue;
    }

    /**
     * get current time in simulation
     *
     * @return current time
     */
    public int getCurrentTime() {
        return currentTime;
    }

    /**
     * get the number of counters
     *
     * @return number of counters
     */
    public int getCounters() {
        return counters;
    }
}
