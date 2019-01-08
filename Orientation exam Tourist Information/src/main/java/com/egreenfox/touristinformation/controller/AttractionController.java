package com.egreenfox.touristinformation.controller;


import com.egreenfox.touristinformation.entity.Attraction;
import com.egreenfox.touristinformation.entity.CheapestAttractionQuery;
import com.egreenfox.touristinformation.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AttractionController {

    private AttractionService attractionService;

    @Autowired
    public AttractionController(AttractionService attractionService) {
        this.attractionService = attractionService;
    }

    @GetMapping({"","/"})
    public String showMain(Model model, @ModelAttribute(value = "error")String error, @ModelAttribute(value = "getOne") Attraction attraction ){
        if (attraction != null){
            model.addAttribute("getOneToEdit", attraction);
        }
        model.addAttribute("attractions", attractionService.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addNewAttraction(@ModelAttribute @Valid Attraction attraction, BindingResult result, RedirectAttributes attributes){
        if(attraction != null && !result.hasErrors()) {
            attractionService.save(attraction);
            return "redirect:/";
        }
        attributes.addFlashAttribute("error","Please provide valid input");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editAttraction(@PathVariable(value = "id")Long id, RedirectAttributes attributes){
        if(attractionService.findById(id) != null) {
            attributes.addFlashAttribute("getOne", attractionService.findById(id));
        }
        return "redirect:/";
    }

    @GetMapping("/budge")
    @ResponseBody
    public CheapestAttractionQuery findCheapestAttractions(){
        return attractionService.findCheapest();
    }
}
