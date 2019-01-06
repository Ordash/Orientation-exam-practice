package com.greenfox.urlshortener.services;

import com.greenfox.urlshortener.entities.Link;
import com.greenfox.urlshortener.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {

    private LinkRepository linkRepository;

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public Link findByAlias(String alias){
        return linkRepository.findByAlias(alias);
    }

    public void save(Link link){
        linkRepository.save(link);
    }

    public List<Link> findAll(){
        return linkRepository.findAll();
    }

    public String fourDigitRandom(){
        return (int)(Math.random()*10) +""+ (int)(Math.random()*10) +""+ (int)(Math.random()*10)+ ""+ (int)(Math.random()*10);
    }

    public Link incrementHitCount(String alias){
        Link incremented = linkRepository.findByAlias(alias);
        incremented.setHitCount(linkRepository.findByAlias(alias).getHitCount()+1);
        linkRepository.save(incremented);
        return incremented;
    }
}
