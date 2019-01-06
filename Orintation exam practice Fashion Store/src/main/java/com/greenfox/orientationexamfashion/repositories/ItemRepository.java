package com.greenfox.orientationexamfashion.repositories;

import com.greenfox.orientationexamfashion.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {


    Item findFirstByNameAndSize(String name, String size);

    @Query("SELECT DISTINCT i.name FROM Item i")
    List<String> findDistinctName();

    @Query("SELECT DISTINCT i.size FROM Item i")
    List<String> findDistinctSize();
}
