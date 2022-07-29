package com.skilldistillery.filmquery.entities;

import java.util.Objects;

public class Film {
	private int filmId;
	private String title;
	private String description;
	private int year;
	private int languageId;
	private double rentalDuration;
	private double rentalrate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	
	
	public Film() {
	}
	public Film(int filmId, String title, String description, int year, int languageId,
			double rentalDuration, double rentalrate, int length, double replacementCost, String rating,
			String specialFeatures) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.year = year;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalrate = rentalrate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}
	public int getId() {
		return filmId;
	}
	public void setId(int id) {
		this.filmId = filmId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public double getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(double rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public double getRentalrate() {
		return rentalrate;
	}
	public void setRentalrate(double rentalrate) {
		this.rentalrate = rentalrate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public double getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", description=" + description + ", year=" + year
				+ ", languageId=" + languageId + ", rentalDuration=" + rentalDuration
				+ ", rentalrate=" + rentalrate + ", length=" + length + ", replacementCost=" + replacementCost
				+ ", rating=" + rating + ", specialFeatures=" + specialFeatures + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, filmId,  languageId, length, rating, rentalDuration, rentalrate,
				replacementCost, specialFeatures, title, year);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && filmId == other.filmId
				&& languageId == other.languageId && length == other.length
				&& Objects.equals(rating, other.rating)
				&& Double.doubleToLongBits(rentalDuration) == Double.doubleToLongBits(other.rentalDuration)
				&& Double.doubleToLongBits(rentalrate) == Double.doubleToLongBits(other.rentalrate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title)
				&& year == other.year;
	}
	
	
	
	
	
}
