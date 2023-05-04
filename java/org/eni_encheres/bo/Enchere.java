package org.eni_encheres.bo;

import java.sql.Date;

public class Enchere {

	//attributs
	private Utilisateur user;
	private Article_Vendu article;
	private Date auction_date;
	private int auction_price;
	
	//constructeurs
	public Enchere() {}
	
	public Enchere(Utilisateur user,Article_Vendu article, Date auction_date, int auction_price) {
		this.user = user;
		this.article = article;
		this.auction_date = auction_date;
		this.auction_price = auction_price;
	}
	
	public Enchere(Date auction_date, int auction_price) {
		this.auction_date = auction_date;
		this.auction_price = auction_price;
	}
	
	

	//getters et setters
	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Article_Vendu getArticle() {
		return article;
	}

	public void setArticle(Article_Vendu article) {
		this.article = article;
	}

	public Date getAuctionDate() {
		return auction_date;
	}

	public void setAuctionDate(Date auction_date) {
		this.auction_date = auction_date;
	}

	public int getAuctionPrice() {
		return auction_price;
	}

	public void setAuctionPrice(int auction_price) {
		this.auction_price = auction_price;
	}
	
	
	
}
