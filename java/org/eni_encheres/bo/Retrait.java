package org.eni_encheres.bo;

public class Retrait {

	//attributs
	private int no_article;
	private String street;
	private String zip_code;
	private String town;
	
	//constructeurs
	public Retrait() {}
	
	public Retrait(int no_article, String street, String zip_code, String town) {
		this.no_article = no_article;
		this.street = street;
		this.zip_code = zip_code;
		this.town = town;
	}
	
	public Retrait(String rue, String zip_code, String town) {
		this.street = rue;
		this.zip_code = zip_code;
		this.town = town;
	}
	
	//getters et setters
	public int getNo_article() {
		return no_article;
	}

	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}

	public String getRue() {
		return street;
	}

	public void setRue(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zip_code;
	}

	public void setZipCode(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	
	
}
