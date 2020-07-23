package com.collabera.jump.worldapp;

import java.util.List;

public interface CountryDAOInterface {
	
	public List<Country> getAllCountries();
	
	public Country getCountry(int id);
}