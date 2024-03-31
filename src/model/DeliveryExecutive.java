package model;

public class DeliveryExecutive {
    private String name;
    private Location location;

    public DeliveryExecutive(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
