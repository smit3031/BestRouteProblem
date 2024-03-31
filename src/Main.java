import model.Location;
import model.Restaurant;
import model.Customer;
import util.OptimalPathFinder;

public class Main {
    public static void main(String[] args) {
        // Define locations
        Location DE = new Location(12.971598, 77.594566); // Bangalore coordinates
        Location R1 = new Restaurant(12.935682, 77.621873, 30); // Restaurant 1 coordinates with a preparation time of 30 minutes
        Location R2 = new Restaurant(12.950934, 77.699111, 10); // Restaurant 2 coordinates with a preparation time of 10 minutes
        Location C1 = new Customer(12.966705, 77.749374); // Customer 1 coordinates
        Location C2 = new Customer(12.927923, 77.627108); // Customer 2 coordinates

        // Set the speed of delivery agent
        double speed = 20; // km/h

        // Create an OptimalPathFinder object
        OptimalPathFinder pathFinder = new OptimalPathFinder(speed, DE);

        // Find the optimal path
        String optimalPath = pathFinder.findOptimalPath((Restaurant) R1, (Restaurant) R2, (Customer) C1, (Customer) C2);

        // Output the optimal path
        System.out.println("Optimal path: " + optimalPath);
    }
}
