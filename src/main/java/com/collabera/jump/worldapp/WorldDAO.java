package com.collabera.jump.worldapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorldDAO implements CountryDAOInterface, CityDAOInterface{
	
	List<Country> countryList;

	public WorldDAO() {
		countryList = new ArrayList<Country>();
	}

	// retrieve list of all countries
	@Override
	public List<Country> getAllCountries() {
		Connection con = ConnectionFactory.getConnection();

		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Country");

			List<Country> countryList = new ArrayList<Country>();

			while (rs.next()) {
				Country c = new Country();
				c.setCountryId(rs.getInt("CountryId"));
				c.setCountryName(rs.getString("CountryName"));
				c.setPopulation(rs.getInt("Population"));
				c.setCityId(rs.getInt("CityId"));
				countryList.add(c);
			}

			con.close();
			stmt.close();
			rs.close();

			return countryList;
		} catch(SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	//retrieve a country by id
	@Override
	public Country getCountry(int id) {
		Connection con = ConnectionFactory.getConnection();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Country WHERE CountryId=" + id);
			if (rs.next()) {
				Country c = new Country();
				c.setCountryId(rs.getInt("CountryId"));
				c.setCountryName(rs.getString("CountryName"));
				c.setPopulation(rs.getInt("Population"));
				c.setCityId(rs.getInt("CityId"));

				con.close();
				stmt.close();
				rs.close();

				return c;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}


	//retrieve all cities
	@Override
	public List<City> getAllCities() {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM City");
			
			List<City> cityList = new ArrayList<City>();
			
			while(rs.next()) {
				City cit = new City();
				cit.setCityId(rs.getInt("CityId"));
				cit.setCityName(rs.getString("CityName"));
				cit.setCapital(rs.getString("isCapital"));
				cityList.add(cit);
			}

			con.close();
			stmt.close();
			rs.close();

			return cityList;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}


	//retrieve cities by id
	@Override
	public List<City> getCities(int id) {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM City WHERE CityId=" + id);
			
			List<City> cityList = new ArrayList<City>();
			
			while(rs.next()) {
				City cit = new City();
				cit.setCityId(rs.getInt("CityId"));
				cit.setCityName(rs.getString("CityName"));
				cit.setCapital(rs.getString("isCapital"));
				cityList.add(cit);
			}

			con.close();
			stmt.close();
			rs.close();

			return cityList;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	// retrieve all capital Cities
	@Override
	public List<City> getCapitalCities(String isCapital) {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM City WHERE isCapital='" + isCapital + "'");
			
			List<City> cityList = new ArrayList<City>();
			
			while(rs.next()) {
				City cit = new City();
				cit.setCityId(rs.getInt("CityId"));
				cit.setCityName(rs.getString("CityName"));
				cit.setCapital(rs.getString("isCapital"));
				cityList.add(cit);
			}

			con.close();
			stmt.close();
			rs.close();

			return cityList;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}