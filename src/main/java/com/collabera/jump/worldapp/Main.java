package com.collabera.jump.worldapp;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		WorldDAO worldDAO = new WorldDAO();
		Scanner input = new Scanner(System.in);
		String storedInput = "";
		System.out.println(".............................................................................");
		System.out.println("Welcome to WorldApp!");
		while(!storedInput.equalsIgnoreCase("q"))
		{
			System.out.println(".............................................................................");
			System.out.println("Please select an option below:");
			System.out.println(" 1) Show all Countries ");
			System.out.println(" 2) Show Countries by id");
			System.out.println(" 3) Show all Cities");
			System.out.println(" 4) Show Capital Cities");
			System.out.println(" Q) Exit");

			storedInput = input.nextLine();

			if(storedInput.equals("1")) {
				// Shows all the countries in the db
				System.out.println();
				for (Country c : worldDAO.getAllCountries())
					System.out.println("Country: [Id : "+c.getCountryId()+", Name : "+ c.getCountryName() + ", Population : "+c.getPopulation() + " ]");
				
			} else if(storedInput.equals("2")) {
				// Shows the Country with cities with given id
				System.out.println();
				System.out.println("Enter the id: ");
				storedInput = input.nextLine();
				int idInput = Integer.parseInt(storedInput);

				Country country = worldDAO.getCountry(idInput);
				System.out.println("  Country: [Id : "+country.getCountryId()+", Name : "+ country.getCountryName() + ", Population : "+country.getPopulation() + " ]");
				for (City cit : worldDAO.getCities(country.getCityId()))
					System.out.println("      City: [Id : "+cit.getCityId()+", Name : "+ cit.getCityName() + ", isCapital : "+cit.getCapital() + " ]");
				
			} else if(storedInput.equals("3")) {
				// Shows all the cities in the db
				for (City cit : worldDAO.getAllCities())
					System.out.println("  City: [Id : "+cit.getCityId()+", Name : "+ cit.getCityName() + ", isCapital : "+cit.getCapital() + " ]");

			} else if(storedInput.equals("4")) {
				// Shows the Capital cities with their Country.
				System.out.println();
				for (City cit : worldDAO.getCapitalCities("Y")) {
					System.out.println("  City: [Id : "+cit.getCityId()+", Name : "+ cit.getCityName() + ", isCapital : "+cit.getCapital() + " ]");
					Country country = worldDAO.getCountry(cit.getCityId());
					System.out.println("     Country: [Id : "+country.getCountryId()+", Name : "+ country.getCountryName() + "   , Population : "+country.getPopulation() + " ]");
				 }
			}

		}

		input.close();
	}
}