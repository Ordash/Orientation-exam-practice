package com.egreenfox.touristinformation.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "attractions")
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min=2, max=30)
    private String name;
    @NotNull
    @Size(min=2, max=30)
    private String city;
    @NotNull
    private Double price;
    @NotNull
    private Double longitude;
    @NotNull
    private Double latitude;
    @NotNull
    @Size(min=2, max=30)
    private String category;
    @NotNull
    private Integer duration;
    @NotNull
    private Integer recommendedAge;


    public Attraction() {
    }

    public Attraction(String name, String city, Double price, Double longitude, Double latitude, String category, Integer duration, Integer recommendedAge) {
        this.name = name;
        this.city = city;
        this.price = price;
        this.longitude = longitude;
        this.latitude = latitude;
        this.category = category;
        this.duration = duration;
        this.recommendedAge = recommendedAge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getRecommendedAge() {
        return recommendedAge;
    }

    public void setRecommendedAge(Integer recommendedAge) {
        this.recommendedAge = recommendedAge;
    }
}
