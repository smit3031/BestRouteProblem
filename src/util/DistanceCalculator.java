package util;
import model.Location;

public class DistanceCalculator {
    private static final int EARTH_RADIUS_KM = 6371;

    public static double haversineDistance(Location loc1, Location loc2) {
        double lat1 = loc1.getLatitude();
        double lon1 = loc1.getLongitude();
        double lat2 = loc2.getLatitude();
        double lon2 = loc2.getLongitude();

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = calculateSquareOfHalfTheChordLength(latDistance) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        calculateSquareOfHalfTheChordLength(lonDistance);

        double c = calculateAngularDistance(a);

        return EARTH_RADIUS_KM * c;
    }

    private static double calculateSquareOfHalfTheChordLength(double distance) {
        return Math.sin(distance / 2) * Math.sin(distance / 2);
    }

    private static double calculateAngularDistance(double a) {
        return 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }
}
