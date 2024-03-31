package model;

import java.util.ArrayList;
import java.util.List;

public class State {
    public Location currentLocation;
    List<Order> remainingOrders;
    public double timeSpent;

    public State(Location currentLocation, List<Order> remainingOrders, double timeSpent) {
        this.currentLocation = currentLocation;
        this.remainingOrders = new ArrayList<>(remainingOrders);
        this.timeSpent = timeSpent;
    }
}
