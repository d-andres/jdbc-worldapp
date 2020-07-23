package com.collabera.jump.worldapp;

public class City {

	private int cityId;
	private String cityName;
	private String isCapital;
	

	public City() {
		super();
	}
	
	public City(int cityId, String cityName, String isCapital) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.isCapital = isCapital;
	}

	public int getCityId() { return cityId; }

	public void setCityId(int cityId) { this.cityId = cityId; }

	public String getCityName() { return cityName; }

	public void setCityName(String cityName) { this.cityName = cityName; }

	public String getCapital() { return isCapital; }

	public void setCapital(String isCapital) { this.isCapital = isCapital; }

	
}