package org.eni_encheres.bo;

import java.sql.Date;

public class Enchere {

	//attributs
	private int user;
	private int article;
	private Date auction_date;
	private int auction_price;
	
	//constructeurs
	public Enchere() {}
	
	public Enchere(int user,int article, Date auction_date, int auction_price) {
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
