package com.greenfox.urlshortener.controllers;

import com.greenfox.urlshortener.entities.Link;
import com.greenfox.urlshortener.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MainController {

    private LinkService linkService;

    @Autowired
    public MainController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping({"/",""})
    public String showMain(@ModelAttribute(value = "link")Link link,
                           @ModelAttribute(value = "error") String error,
                           @ModelAttribute(value = "message") String message){
        return "index";
    }

    @PostMapping("/save-link")
    public String saveLink(@ModelAttribute(value = "link") Link link, RedirectAttributes attributes) {

        if(linkService.findByAlias(link.getAlias()) != null){
            attributes.addFlashAttribute("error", "Your alias is already in use!");
        } else {
            link.setSecretCode(linkService.fourDigitRandom());
            linkService.save(link);
            attributes.addFlashAttribute("message", "Your url is aliased to " + link.getAlias() + " and your secret code is " + link.getSecretCode());
        }
        return "redirect:/";
    }

    @GetMapping("/a/{alias}")
    public String aliasCounter(@PathVariable(name="alias") String alias ){
        return "redirect:"+linkService.incrementHitCount(alias).getUrl();
    }

    @GetMapping("/api/links")
    @ResponseBody
    public List<Link> responseWithEntries(){
        return linkService.findAll();
    }


}
