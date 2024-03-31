package model;

public class Restaurant extends Location {
    private int preparationTime; // in minutes

    public Restaurant(double latitude, double longitude, int preparationTime) {
        super(latitude, longitude);
        this.preparationTime = preparationTime;
    }

    public int getPreparationTime() {
        return preparationTime;
    }
}
