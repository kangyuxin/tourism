package com.test.tourism.model;

import lombok.Data;

import java.util.Date;
@Data
public class Travel {
    private Integer travelId;

    private String travelName;

    private String createTime;

    private String travelTitle;

    private String travelCover;

    private String travelImgs;

    private String travelDetail;

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTravelTitle() {
        return travelTitle;
    }

    public void setTravelTitle(String travelTitle) {
        this.travelTitle = travelTitle;
    }

    public String getTravelCover() {
        return travelCover;
    }

    public void setTravelCover(String travelCover) {
        this.travelCover = travelCover;
    }

    public String getTravelImgs() {
        return travelImgs;
    }

    public void setTravelImgs(String travelImgs) {
        this.travelImgs = travelImgs;
    }

    public String getTravelDetail() {
        return travelDetail;
    }

    public void setTravelDetail(String travelDetail) {
        this.travelDetail = travelDetail;
    }
}