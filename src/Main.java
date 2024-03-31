import model.Location;
import model.Restaurant;
import model.Customer;
import util.OptimalPathFinder;

public class Main {
    public static void main(String[] args) {

        double speed = 20; // km/h

        Location DE = new Location(12.971598, 77.594566);
        Location R1 = new Restaurant(12.935682, 77.621873, 30);
        Location R2 = new Restaurant(15.950934, 78.699111, 10);
        Location C1 = new Customer(12.966705, 77.749374);
        Location C2 = new Customer(12.927923, 77.627108);

        OptimalPathFinder pathFinder = new OptimalPathFinder(speed, DE);

        String optimalPath = pathFinder.findOptimalPath((Restaurant) R1, (Restaurant) R2, (Customer) C1, (Customer) C2);

        System.out.println("Optimal path: " + optimalPath);
    }
}
