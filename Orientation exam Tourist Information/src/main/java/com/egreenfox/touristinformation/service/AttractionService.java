package com.egreenfox.touristinformation.service;

import com.egreenfox.touristinformation.entity.Attraction;
import com.egreenfox.touristinformation.entity.CheapestAttractionQuery;
import com.egreenfox.touristinformation.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttractionService {

    private AttractionRepository attractionRepository;

    @Autowired
    public AttractionService(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }

    public List<Attraction> findAll() {
        return attractionRepository.findAll();
    }

    public void save(Attraction attraction) {
        attractionRepository.save(attraction);
    }

    public Attraction findById(Long id) {
        if(attractionRepository.findById(id).isPresent()) {
            return attractionRepository.findById(id).get();
        }
        return null;
    }

    public CheapestAttractionQuery findCheapest(){
        List<Attraction> cheapest = new ArrayList<>();
        cheapest.add(attractionRepository.findTop1ByCategoryOrderByPrice("museum"));
        cheapest.add(attractionRepository.findTop1ByCategoryOrderByPrice("park"));
        cheapest.add(attractionRepository.findTop1ByCategoryOrderByPrice("restaurant"));
        CheapestAttractionQuery c = new CheapestAttractionQuery();
        c.setAttractions(cheapest);
        return c;
    }
}
