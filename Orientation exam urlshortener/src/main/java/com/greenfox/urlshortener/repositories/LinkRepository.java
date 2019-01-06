package com.greenfox.urlshortener.repositories;

import com.greenfox.urlshortener.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

    Link findByAlias(String alias);
}
