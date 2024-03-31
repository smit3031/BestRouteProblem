package util;

import java.util.HashMap;
import java.util.Map;
import model.Location;
import model.Restaurant;
import model.Customer;

public class OptimalPathFinder {
    private final Location DE;
    private final double speed;

    public OptimalPathFinder(double speed, Location DE) {
        this.speed = speed;
        this.DE = DE;
    }

    public String findOptimalPath(Restaurant R1, Restaurant R2, Customer C1, Customer C2) {
        Map<String, Double> pathTimes = new HashMap<>();

        pathTimes.put("DE -> R2 -> R1 -> C1 -> C2", calculateTotalDeliveryTime(DE, R2, R1, C1, C2));
        pathTimes.put("DE -> R2 -> R1 -> C2 -> C1", calculateTotalDeliveryTime(DE, R2, R1, C2, C1));
        pathTimes.put("DE -> R2 -> C2 -> R1 -> C1", calculateTotalDeliveryTime(DE, R2, C2, R1, C1));
        pathTimes.put("DE -> R1 -> R2 -> C1 -> C2", calculateTotalDeliveryTime(DE, R1, R2, C1, C2));
        pathTimes.put("DE -> R1 -> C1 -> R2 -> C2", calculateTotalDeliveryTime(DE, R1, C1, R2, C2));
        pathTimes.put("DE -> R1 -> R2 -> C2 -> C1", calculateTotalDeliveryTime(DE, R1, R2, C2, C1));

        String optimalPath = "";
        double minTime = Double.MAX_VALUE;

        for (Map.Entry<String, Double> entry : pathTimes.entrySet()) {
            if (entry.getValue() < minTime) {
                minTime = entry.getValue();
                optimalPath = entry.getKey();
            }
        }

        return optimalPath;
    }

    private double calculateTotalDeliveryTime(Location start, Location... locations) {
        double totalTime = 0;

        Location startLocation = start;
        for (Location currentLocation : locations) {
            double timeToLocation = calculateTimeToLocation(startLocation, currentLocation);
            totalTime += timeToLocation;

            if (currentLocation instanceof Restaurant) {
                double preparationTimeLeft = getPreparationTimeLeft((Restaurant) currentLocation, totalTime);
                totalTime += preparationTimeLeft;
            }
            startLocation = currentLocation;
        }

        return totalTime;
    }

    private double getPreparationTimeLeft(Restaurant location, double timeToLocation) {
        return Math.max(location.getPreparationTime() - timeToLocation, 0);
    }

    private double calculateTimeToLocation(Location from, Location to) {
        double distance = DistanceCalculator.haversineDistance(from, to);
        return distance / speed;
    }
}
