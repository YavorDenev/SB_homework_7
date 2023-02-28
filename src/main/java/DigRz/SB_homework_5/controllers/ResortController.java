package DigRz.SB_homework_5.controllers;

import DigRz.SB_homework_5.entities.Resort;
import DigRz.SB_homework_5.repositories.ResortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.GeneratedValue;

@Controller
@RequestMapping("/resorts")
public class ResortController {

    @Autowired
    private ResortRepository resortRepo;

    @GetMapping
    private String showAllResorts (Model m) {
       m.addAttribute("resorts", resortRepo.findAll());
       return "/resorts/start";
    }

    @GetMapping("/create")
    private String createResort (Model m) {
        Resort resort = new Resort();
        m.addAttribute("resort", resort);
        return "/resorts/create";
    }

    @PostMapping("/submit")
    private ModelAndView submitResort (Resort r) {
        resortRepo.save(r);
        return new ModelAndView("redirect:/resorts");
    }

    @GetMapping("/edit/{id}")
    private String editResort (@PathVariable(name = "id") Integer id, Model m) {
        m.addAttribute("resort", resortRepo.findById(id));
        return "/resorts/edit";
    }

    @PostMapping("/delete/{id}")
    private ModelAndView deleteResort (@PathVariable(name = "id") Integer id) {
        resortRepo.deleteById(id);
        return new ModelAndView("redirect:/resorts");
    }

}
