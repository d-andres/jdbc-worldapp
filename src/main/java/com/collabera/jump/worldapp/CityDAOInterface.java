package com.collabera.jump.worldapp;

import java.util.List;

public interface CityDAOInterface {

	public List<City> getAllCities();

	public List<City> getCities(int id);

	public List<City> getCapitalCities(String isCapital);
}