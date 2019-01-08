package com.egreenfox.touristinformation.repository;

import com.egreenfox.touristinformation.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {

    Attraction findTop1ByCategoryOrderByPrice(String category);
}
