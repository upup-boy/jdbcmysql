package com.yunyun.application.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Video implements Serializable {
    private int id;

    private String titile;

    private String summary;

    private int price;

    @JsonProperty("cover_img")
    private String coverImg;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale ="zh", timezone = "GMT+8")
    private Date createTime;

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Chapter> chapterList;

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    public Video(){}

    public Video(int id, String title){
        this.id =id;
        this.titile=title;

        this.createTime = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", titile='" + titile + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", coverImg='" + coverImg + '\'' +
                ", createTime=" + createTime +
                ", chapterList=" + chapterList +
                '}';
    }
}
