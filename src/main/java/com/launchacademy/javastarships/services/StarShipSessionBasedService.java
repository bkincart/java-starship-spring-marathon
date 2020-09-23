package com.launchacademy.javastarships.services;

import com.launchacademy.javastarships.models.StarShip;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class StarShipSessionBasedService implements StarShipService {
  private List<StarShip> starShips;

  public StarShipSessionBasedService() {
    this.starShips = new ArrayList<StarShip>();

    StarShip starShip = new StarShip();

    starShip.setId(1);
    starShip.setName("Rocinante");
    starShip.setDescription("Mars built for Tilting at Windmills");
    starShip.setFuelCapacity(250);
    this.starShips.add(starShip);


    starShip = new StarShip();
    starShip.setId(2);
    starShip.setName("Moya");
    starShip.setDescription("Leviathan transport vessel; a living sentient bio-mechanical space ship. ");
    starShip.setFuelCapacity(633);
    this.starShips.add(starShip);

    starShip = new StarShip();
    starShip.setId(3);
    starShip.setName("Lexx");
    starShip.setDescription("Enormous sentient insect genetically modified for space travel and planet-destroying capabilities.");
    starShip.setFuelCapacity(1000);
    this.starShips.add(starShip);
  }

  public List<StarShip> findAll() {
    return this.starShips;
  }

  public StarShip get(Integer id) {
    return this.starShips.get(id-1);
  }

  public void addToList(StarShip starShip) {
    this.starShips.add(starShip);
  }
}
