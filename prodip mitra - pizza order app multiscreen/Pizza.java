package assignment.prog38448.myapplication;

public class Pizza {
    private double size = 9;
    private double chicken = 0;
    private double bacon = 0;
    private double mashroom = 0;
    private double delivery = 0;

    public Pizza(double size, double chicken, double bacon, double mashroom, double delivery) {
        this.size = size;
        this.chicken = chicken;
        this.bacon = bacon;
        this.mashroom = mashroom;
        this.delivery = delivery;
    }

    public Pizza() {
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getChicken() {
        return chicken;
    }

    public void setChicken(double chicken) {
        this.chicken = chicken;
    }

    public double getBacon() {
        return bacon;
    }

    public void setBacon(double bacon) {
        this.bacon = bacon;
    }

    public double getMashroom() {
        return mashroom;
    }

    public void setMashroom(double mashroom) {
        this.mashroom = mashroom;
    }

    public double getDelivery() {
        return delivery;
    }

    public void setDelivery(double delivery) {
        this.delivery = delivery;
    }
}
