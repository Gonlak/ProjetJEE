package org.eni_encheres.bo;

import java.sql.Date;
import java.util.List;



public class Enchere {

	//attributs
	private List<Utilisateur> user;
	private List<Article_Vendu> article;
	private Date auction_date;
	private int auction_price;
	
	//constructeurs
	public Enchere() {}
	
	public Enchere(List<Utilisateur> user,List<Article_Vendu> article, Date auction_date, int auction_price) {
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
	public List<Utilisateur> getUser() {
		return user;
	}

	public void setUser(List<Utilisateur> user) {
		this.user = user;
	}

	public List<Article_Vendu> getArticle() {
		return article;
	}

	public void setArticle(List<Article_Vendu> article) {
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
