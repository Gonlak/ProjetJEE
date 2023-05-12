package org.eni_encheres.bo;

import java.sql.Date;
import java.time.LocalDate;

public class Enchere {

	//attributs
	private int user;
	private int article;
	private int noUtilisateur;
	private int noArticle;
	private Article_Vendu article_vendu;
	private LocalDate auction_date;
	private int auction_price;
	
	//constructeurs
	public Enchere() {}
	
	public Enchere(int user,int article, LocalDate auction_date, int auction_price) {
		this.user = user;
		this.article = article;
		this.auction_date = auction_date;
		this.auction_price = auction_price;
	}
	
	public Enchere(LocalDate auction_date, int auction_price) {
		this.auction_date = auction_date;
		this.auction_price = auction_price;
	}

	public Enchere(int noUtilisateur, int noArticle, LocalDate auction_date, int auction_price, Article_Vendu article_vendu) {
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
		this.auction_date = auction_date;
		this.auction_price = auction_price;
		this.article_vendu = article_vendu;
	}



	//getters et setters
	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getArticle() {
		return article;
	}

	public void setArticle(int article) {
		this.article = article;
	}

	public LocalDate getAuctionDate() {
		return auction_date;
	}

	public void setAuctionDate(LocalDate auction_date) {
		this.auction_date = auction_date;
	}

	public int getAuctionPrice() {
		return auction_price;
	}

	public void setAuctionPrice(int auction_price) {
		this.auction_price = auction_price;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
}
