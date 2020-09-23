package com.launchacademy.javastarships.controllers;

import com.launchacademy.javastarships.models.StarShip;
import com.launchacademy.javastarships.services.StarShipService;
import com.launchacademy.javastarships.services.StarShipSessionBasedService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/starships")
public class StarShipsController {

  @Autowired
  private StarShipService service;

  @GetMapping
  public String getIndex(Model model) {
    List<StarShip> starships = service.findAll();
    model.addAttribute("starships", starships);
    return "starships/index";
  }

  @GetMapping("/{starShipId}")
  public String getShow(@PathVariable Integer starShipId, Model model) {
    StarShip starship = service.get(starShipId);
    model.addAttribute("starship", starship);
    return "starships/show";
  }

  @GetMapping("/new")
  public String getNew(@ModelAttribute StarShip starShip) {
    return "starships/new";
  }

  @PostMapping
  public String postNew(@ModelAttribute StarShip starship){
    // populate starship object with form input
    List<StarShip> starShips = service.findAll();
    int newId = starShips.size() + 1;
    starship.setId(newId);
    //persist
    service.addToList(starship);
    // redirect to the show page
    String path = "redirect:/starships/" + starship.getId();
    return path;
  }
}
