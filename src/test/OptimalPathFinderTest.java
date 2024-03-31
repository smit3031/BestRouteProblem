package test;
import model.Customer;
import model.Location;
import model.Restaurant;
import org.junit.Test;

import util.OptimalPathFinder;

import static org.junit.Assert.assertEquals;


public class OptimalPathFinderTest {
    @Test
    public void testOptimalPathFinderPath1() {
        Location DE = new Location(12.971598, 77.594566);
        Location R1 = new Restaurant(12.935682, 77.621873, 30);
        Location R2 = new Restaurant(12.950934, 77.699111, 10);
        Location C1 = new Customer(12.966705, 77.749374);
        Location C2 = new Customer(12.927923, 77.627108);

        double speed = 20; // km/h

        OptimalPathFinder pathFinder = new OptimalPathFinder(speed, DE);

        String expectedPath = "DE -> R2 -> C2 -> R1 -> C1";
        String actualPath = pathFinder.findOptimalPath((Restaurant) R1, (Restaurant) R2, (Customer) C1, (Customer) C2);
        assertEquals(expectedPath, actualPath);
    }
}
