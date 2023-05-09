package org.eni_encheres.bo;

import java.util.List;

public class Categorie {

	//attributs
	private int no_category;
	private String libelle;
	private List<Article_Vendu> articles;
	
	//constructeurs
	public Categorie() {}
	
	public Categorie(int no_category, String libelle,List<Article_Vendu> articles) {
		this.no_category = no_category;
		this.libelle = libelle;
		this.articles = articles;
	}
	
	public Categorie(String libelle,List<Article_Vendu> articles) {
		this.libelle = libelle;
		this.articles = articles;
	}

<<<<<<< HEAD
	public Categorie(String libelle) {
		this.libelle = libelle;
	}
	
	public Categorie(int no_category, String libelle) {
		super();
=======
	public Categorie(int no_category, String libelle) {
>>>>>>> 8dc6446707aa0cc2d577467d36867752f08eb772
		this.no_category = no_category;
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

	public List<Article_Vendu> getArticles() {
		return articles;
	}

	public void setArticles(List<Article_Vendu> articles) {
		this.articles = articles;
	}
	
	
	
}
