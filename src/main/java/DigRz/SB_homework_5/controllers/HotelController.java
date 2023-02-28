package DigRz.SB_homework_5.controllers;

import DigRz.SB_homework_5.entities.Hotel;
import DigRz.SB_homework_5.repositories.HotelRepository;
import DigRz.SB_homework_5.repositories.ResortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    private ResortRepository resortRepo;

    @GetMapping
    private String showAllHotels (Model m) {
        m.addAttribute("hotels", hotelRepo.findAll());
        return "/hotels/start";
    }

    @GetMapping("/create")
    private String createHotel (Model m) {
        Hotel hotel = new Hotel();
        m.addAttribute("hotel", hotel);
        m.addAttribute("resorts", resortRepo.findAll());
        return "/hotels/create";
    }

    @PostMapping("/submit")
    private ModelAndView submitHotel (Hotel hotel) {
        hotelRepo.save(hotel);
        return new ModelAndView("redirect:/hotels");
    }

    @GetMapping("/edit/{id}")
    private String editHotel (@PathVariable(name = "id") Integer id, Model m) {
        m.addAttribute("hotel", hotelRepo.findById(id));
        m.addAttribute("resorts", resortRepo.findAll());
        return "/hotels/edit";
    }

    @PostMapping("/delete/{id}")
    private ModelAndView deleteHotel (@PathVariable(name = "id") Integer id) {
        hotelRepo.deleteById(id);
        return new ModelAndView("redirect:/hotels");
    }

}
