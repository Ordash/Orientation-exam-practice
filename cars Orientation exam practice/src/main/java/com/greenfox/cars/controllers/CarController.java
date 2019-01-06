package com.greenfox.cars.controllers;

import com.greenfox.cars.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = {"/", ""})
    public String showPage(Model model, @ModelAttribute(value = "error")String error){
        model.addAttribute("error",error);
        return "index";
    }

    @GetMapping(value = "/search")
    public String searchByLicencePlate(RedirectAttributes attributes, @RequestParam(value = "q", required = false) String licencePlate, Model model,
                                       @RequestParam(value = "police", required = false)Integer p,
                                       @RequestParam(value = "diplomat", required = false)Integer d) {

        if(d != null){
            model.addAttribute("result", carService.findAllDiplomatCars());
        }
        if(p != null){
            model.addAttribute("result", carService.findAllPoliceCars());
        }
        if (licencePlate != null && carService.findByLicencePlate(licencePlate) != null) {
            model.addAttribute("result", carService.findByLicencePlate(licencePlate));
        } else if(d == null && p == null){
            System.out.println("bgbg");
            attributes.addFlashAttribute("error", "Sorry, the submitted licence plate is not valid");
            return "redirect:/";
        }


        return "index";
    }

    @GetMapping(value = "/search/{brand}")
    public String showBrand(@PathVariable String brand,Model model) {
        if(brand != null){
            model.addAttribute("result", carService.findAllByBrand(brand));
        }
        return "index";
    }
}
