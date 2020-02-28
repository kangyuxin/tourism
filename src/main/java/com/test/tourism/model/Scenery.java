package com.test.tourism.model;

import lombok.Data;

@Data
public class Scenery {
    private Integer sceneryId;

    private String sceneryCity;

    private String sceneryTitle;

    private String sceneryIntroduce;

    private String sceneryPrice;

    private String sceneryRoute;

    private String sceneryCover;

    private String sceneryImgs;

    private String sceneryType;

    public Integer getSceneryId() {
        return sceneryId;
    }

    public void setSceneryId(Integer sceneryId) {
        this.sceneryId = sceneryId;
    }

    public String getSceneryCity() {
        return sceneryCity;
    }

    public void setSceneryCity(String sceneryCity) {
        this.sceneryCity = sceneryCity;
    }

    public String getSceneryTitle() {
        return sceneryTitle;
    }

    public void setSceneryTitle(String sceneryTitle) {
        this.sceneryTitle = sceneryTitle;
    }

    public String getSceneryIntroduce() {
        return sceneryIntroduce;
    }

    public void setSceneryIntroduce(String sceneryIntroduce) {
        this.sceneryIntroduce = sceneryIntroduce;
    }

    public String getSceneryPrice() {
        return sceneryPrice;
    }

    public void setSceneryPrice(String sceneryPrice) {
        this.sceneryPrice = sceneryPrice;
    }

    public String getSceneryRoute() {
        return sceneryRoute;
    }

    public void setSceneryRoute(String sceneryRoute) {
        this.sceneryRoute = sceneryRoute;
    }

    public String getSceneryCover() {
        return sceneryCover;
    }

    public void setSceneryCover(String sceneryCover) {
        this.sceneryCover = sceneryCover;
    }

    public String getSceneryImgs() {
        return sceneryImgs;
    }

    public void setSceneryImgs(String sceneryImgs) {
        this.sceneryImgs = sceneryImgs;
    }

    public String getSceneryType() {
        return sceneryType;
    }

    public void setSceneryType(String sceneryType) {
        this.sceneryType = sceneryType;
    }

    @Override
    public String toString() {
        return "Scenery{" +
                "sceneryId=" + sceneryId +
                ", sceneryCity='" + sceneryCity + '\'' +
                ", sceneryTitle='" + sceneryTitle + '\'' +
                ", sceneryIntroduce='" + sceneryIntroduce + '\'' +
                ", sceneryPrice='" + sceneryPrice + '\'' +
                ", sceneryRoute='" + sceneryRoute + '\'' +
                ", sceneryCover='" + sceneryCover + '\'' +
                ", sceneryImgs='" + sceneryImgs + '\'' +
                ", sceneryType='" + sceneryType + '\'' +
                '}';
    }
}
