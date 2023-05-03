package org.eni_encheres.bo;

import java.sql.Date;

public class Enchere {

	//attributs
	private int no_user;
	private int no_article;
	private Date auction_date;
	private int auction_price;
	
	//constructeurs
	public Enchere() {}
	
	public Enchere(int no_user, int no_article, Date auction_date, int auction_price) {
		this.no_user = no_user;
		this.no_article = no_article;
		this.auction_date = auction_date;
		this.auction_price = auction_price;
	}
	
	public Enchere(Date auction_date, int auction_price) {
		this.auction_date = auction_date;
		this.auction_price = auction_price;
	}
	
	

	//getters et setters
	public int getNoUser() {
		return no_user;
	}

	public void setNoUser(int no_user) {
		this.no_user = no_user;
	}

	public int getNo_article() {
		return no_article;
	}

	public void setNo_article(int no_article) {
		this.no_article = no_article;
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
