package com.test.tourism.model;

import lombok.Data;

@Data
public class Flight {
    private Integer flightId;

    private String flightPrice;

    private String flightSeats;

    private String flightFromCity;

    private String flightToCity;

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(String flightPrice) {
        this.flightPrice = flightPrice;
    }

    public String getFlightSeats() {
        return flightSeats;
    }

    public void setFlightSeats(String flightSeats) {
        this.flightSeats = flightSeats;
    }

    public String getFlightFromCity() {
        return flightFromCity;
    }

    public void setFlightFromCity(String flightFromCity) {
        this.flightFromCity = flightFromCity;
    }

    public String getFrightToCity() {
        return flightToCity;
    }

    public void setFrightToCity(String frightToCity) {
        this.flightToCity = frightToCity;
    }
}
