package com.launchacademy.javastarships.services;

import com.launchacademy.javastarships.models.StarShip;
import java.util.List;

public interface StarShipService {
  List<StarShip> findAll();
  void addToList(StarShip starShip);
  StarShip get(Integer index);
}
