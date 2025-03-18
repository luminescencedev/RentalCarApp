package com.example.RentalCarApp;

class Car {
    private String plateNumber;
    private String brand;
    private int price;
    private boolean rented;

    public Car(String plateNumber, String brand, int price, boolean rented) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.rented = rented;
    }

    public String getPlateNumber() { return plateNumber; }
    public String getBrand() { return brand; }
    public int getPrice() { return price; }
    public boolean isRented() { return rented; }
    public void setRented(boolean rented) { this.rented = rented; }
}