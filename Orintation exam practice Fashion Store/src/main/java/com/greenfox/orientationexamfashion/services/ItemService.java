package com.greenfox.orientationexamfashion.services;

import com.greenfox.orientationexamfashion.entities.Item;
import com.greenfox.orientationexamfashion.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    public Float getSubTotal(Item item,Integer quantity){
        return item.getPrice() * quantity;
    }

    public Item findByNameAndSize(String name, String size){
        return itemRepository.findFirstByNameAndSize(name, size);
    }

    public List<String> findAllDistinctName() {
        return itemRepository.findDistinctName();
    }

    public List<String> findAllDistinctSize(){
        return itemRepository.findDistinctSize();
    }

    public List<Item> filter(Float price, String type){
        if(type.equals("equal")){
            return itemRepository.findAll().stream().filter(item -> item.getPrice().equals(price)).collect(Collectors.toList());
        }
        if(type.equals("lower")){
            return itemRepository.findAll().stream().filter(item -> item.getPrice() < price).collect(Collectors.toList());
        }
        if(type.equals("higher")){
            return itemRepository.findAll().stream().filter(item -> item.getPrice() > price).collect(Collectors.toList());
        }
        return null;
    }
}
