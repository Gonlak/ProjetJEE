package org.eni_encheres.bo;

public class Categorie {

	//attributs
	private int no_category;
	private String libelle;
	
	
	//constructeurs
	public Categorie() {}
	
	public Categorie(int no_category, String libelle) {
		this.no_category = no_category;
		this.libelle = libelle;
	}
	
	public Categorie(String libelle) {
		this.libelle = libelle;
	}

	
	//getters et setters
	public int getNo_categorie() {
		return no_category;
	}

	public void setNo_categorie(int no_category) {
		this.no_category = no_category;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
}
