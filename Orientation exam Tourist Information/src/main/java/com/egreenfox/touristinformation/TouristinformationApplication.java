package com.egreenfox.touristinformation;

import com.egreenfox.touristinformation.entity.Attraction;
import com.egreenfox.touristinformation.repository.AttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TouristinformationApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TouristinformationApplication.class, args);
    }

    private AttractionRepository attractionRepository;

    @Autowired
    public TouristinformationApplication(AttractionRepository attractionRepository) {
        this.attractionRepository = attractionRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        attractionRepository.save(new Attraction("Pulitzer","Budapest",1200.,47.4841,19.0602,"restaurant",60,3));
        attractionRepository.save(new Attraction("Heroes's Square","Budapest",3000.,47.4841,19.0602,"park",30,5));
        attractionRepository.save(new Attraction("Budapest Eye","Budapest",5000.,47.4841,19.0602,"restaurant",40,10));
        attractionRepository.save(new Attraction("House of Terror","Budapest",4000.,47.4841,19.0602,"restaurant",120,15));
        attractionRepository.save(new Attraction("Pulitzer","Budapest",100.,47.4841,19.0602,"park",60,3));
        attractionRepository.save(new Attraction("Pulitzer","Budapest",1200.,47.4841,19.0602,"restaurant",60,3));
        attractionRepository.save(new Attraction("Pulitzer","Budapest",50.,47.4841,19.0602,"museum",60,3));
        attractionRepository.save(new Attraction("Pulitzer","Budapest",1200.,47.4841,19.0602,"museum",60,3));
    }
}

