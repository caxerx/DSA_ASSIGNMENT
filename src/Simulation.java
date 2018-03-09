import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

/**
 * The main class of this simulation, control user input and data output format
 *
 * @author Tsang Tsz Pan
 */
public class Simulation {
    public static void main(String[] args) {
        /*
            INITIALIZE SIMULATION
                LET USER INPUT THE ENVIRONMENT VALUE
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println("------------- SETUP SIMULATION ENVIRONMENT----------------");
        String errMessage = "Please input a positive integer"; //The message that user input a invalid value
        Function<Integer, Boolean> condition = i -> i > 0; //The condition of valid value is input > 0


        //Setup - Let user input
        int simulationLength = inputIntegerUntilValid("Input simulation length (min):", errMessage, scanner, condition);
        int numberOfCounter = inputIntegerUntilValid("Input number of counter:", errMessage, scanner, condition);
        int customerMaxServeTime = inputIntegerUntilValid("Input maximum serving time for a customer:", errMessage, scanner, condition);
        long seedNumber = inputLongUntilValid("Input seed number:", scanner);

        //Initialize Simulation
        Random random = null;
        ShopSimulation sim = new ShopSimulation(numberOfCounter, simulationLength); //Create a shop simulation
        Shop shop = sim.getShop(); //get data object in shop simulation

        //Determine random generate or user input
        if (seedNumber != 0) {
            random = new Random(seedNumber); //create random object only on seed number is not zero
        } else {
            //setup the new error message and condition for user input
            errMessage = "Please input a integer between 0 to maximum serve time";
            condition = i -> i >= 0 && i <= customerMaxServeTime;
        }

        /*
            SIMULATION START
                SHOP WILL START SERVER CUSTOMERS
         */
        System.out.println("------------- START SIMULATION ----------------");
        //Simulation loop
        while (!sim.isSimulationEnd()) {
            int serveTime;

            //every minute's input
            if (seedNumber == 0) {
                serveTime = inputIntegerUntilValid("A customer came with serving time:", errMessage, scanner, condition);
            } else {
                serveTime = random.nextInt(customerMaxServeTime + 1);
            }

            //lapse time with the input
            sim.timeLapse(serveTime);

            //Show round information
            System.out.printf("R%d ", sim.getCurrentTime());
            for (int i = 0; i < numberOfCounter; i++) {
                System.out.printf("Teller_%d[%d]\t", i + 1, shop.getCounterTime(i));
            }
            System.out.print("Waiting Queue:");
            System.out.println(sim.getShop().getQueue());
        }

        /*
            SIMULATION END
                SHOW THE SIMULATION RESULT (ALL DATA EXTRACTED FROM THE SIMULATION OBJECT)
         */
        System.out.println("------------- END OF SIMULATION ----------------");
        System.out.printf("Total minute simulated: %d minutes\n", sim.getCurrentTime());
        System.out.printf("Number of Tellers: %d\n", sim.getCounters());
        System.out.printf("Number of customer served: %d customers\n", sim.getServedCustomer());
        System.out.printf("Average Waiting Line Length: %.1f customers\n", sim.getAverageQueue());
        System.out.printf("Maximum Waiting Line Length: %d customers\n", sim.getMaxQueue());
    }

    /**
     * Let user input a long value, if the user input a invalid number, show error message let them input again
     *
     * @param message prompt message
     * @param scanner scanner object
     * @return Valid number
     */
    public static long inputLongUntilValid(String message, Scanner scanner) {
        Long input = null;
        do {
            System.out.print(message);
            try {
                input = scanner.nextLong();
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid number");
                scanner.nextLine();
            }
        } while (input == null);
        return input;
    }

    /**
     * Let user input a integer, if input is not integer or don't match the condition, show error message and let them input again
     *
     * @param message    prompt message
     * @param errMessage error message
     * @param scanner    scanner object
     * @param condition  valid condition
     * @return Valid integer
     */
    public static int inputIntegerUntilValid(String message, String errMessage, Scanner scanner, Function<Integer, Boolean> condition) {
        Integer input;
        do {
            System.out.print(message);
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a integer");
                scanner.nextLine();
                continue;
            }
            if (condition.apply(input)) {
                return input;
            }
            System.out.println(errMessage);
        } while (true);
    }


}
