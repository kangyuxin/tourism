package com.test.tourism.model;

import lombok.Data;

@Data
public class Hotel {
    private Integer hotelId;

    private String hotelName;

    private String hotelPrice;

    private String hotelLocation;

    private String hotelRooms;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(String hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public String getHotelRooms() {
        return hotelRooms;
    }

    public void setHotelRooms(String hotelRooms) {
        this.hotelRooms = hotelRooms;
    }
}
