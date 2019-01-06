package com.greenfox.orientationexamfashion.controllers;

import com.greenfox.orientationexamfashion.entities.Item;
import com.greenfox.orientationexamfashion.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/warehouse")
public class WarehouseController {
    private ItemService itemService;

    @Autowired
    public WarehouseController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = {"/",""})
    public String warehouse(Model model, @ModelAttribute(value = "error")String error){
        model.addAttribute("distinctSizes", itemService.findAllDistinctSize());
        model.addAttribute("distinctItems", itemService.findAllDistinctName());
        model.addAttribute("items", itemService.findAll());
        return "warehouse";
    }

    @PostMapping(value = "/summary")
    public String getTotal(Model model, @ModelAttribute(name = "name")String name,
                           @ModelAttribute(name = "quantity")String quantity,
                           @ModelAttribute(name = "size")String size, RedirectAttributes attributes){
        if(itemService.findByNameAndSize(name, size) != null) {
            model.addAttribute("summary", itemService.findByNameAndSize(name, size));
            model.addAttribute("subTotal", itemService.getSubTotal(itemService.findByNameAndSize(name, size), Integer.valueOf(quantity)));
        } else {
            attributes.addFlashAttribute("error","Sorry the selected item is not available in the selected size!");
            return "redirect:/warehouse";
        }
        return "summary";
    }

    @GetMapping("/query")
    @ResponseBody
    public List<Item> query(@RequestParam(value = "price")Float price, @RequestParam(value = "type")String type){
        if(price != null && type != null && itemService.filter(price, type) != null){
            return itemService.filter(price, type);
        } else {
            return itemService.findAll();
        }

    }

}
