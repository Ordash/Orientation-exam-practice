package com.egreenfox.touristinformation.entity;

import java.util.List;

public class CheapestAttractionQuery {


    private List<Attraction> attractions;

    public CheapestAttractionQuery() {
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }
}
