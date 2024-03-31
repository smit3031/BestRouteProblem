package model;

public class Order {
    private Restaurant restaurant;
    private Customer customer;
    private boolean isPicked;

    public Order(Restaurant restaurant, Customer customer) {
        this.restaurant = restaurant;
        this.customer = customer;
        this.isPicked = false;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isPicked() {
        return isPicked;
    }

    public void setPicked(boolean picked) {
        isPicked = picked;
    }
}
