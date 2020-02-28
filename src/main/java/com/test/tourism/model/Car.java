package com.test.tourism.model;

import lombok.Data;

@Data
public class Car {
    private Integer carId;

    private String CarPrice;

    private String carSeats;

    private String carLocation;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarPrice() {
        return CarPrice;
    }

    public void setCarPrice(String carPrice) {
        CarPrice = carPrice;
    }

    public String getCarSeats() {
        return carSeats;
    }

    public void setCarSeats(String carSeats) {
        this.carSeats = carSeats;
    }

    public String getCarLocation() {
        return carLocation;
    }

    public void setCarLocation(String carLocation) {
        this.carLocation = carLocation;
    }
}
