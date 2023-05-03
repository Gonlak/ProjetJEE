package org.eni_encheres.bo;

import java.sql.Date;

public class Article_Vendu {

	//attributs
	private int no_article;
	private String article_name;
	private String description;
	private Date start_auction_date;
	private Date end_auction_date;
	private int original_price;
	private int sell_price;
	private int no_user;
	private int no_category;
	
	//constructeurs
	public Article_Vendu() {}
	
	public Article_Vendu(String article_name, String description, Date start_auction_date,
			Date end_auction_date, int original_price, int sell_price, int no_user, int no_category) {
		this.article_name = article_name;
		this.description = description;
		this.start_auction_date = start_auction_date;
		this.end_auction_date = end_auction_date;
		this.original_price = original_price;
		this.sell_price = sell_price;
		this.no_user = no_user;
		this.no_category = no_category;
	}
	
	public Article_Vendu(int no_article, String article_name, String description, Date start_auction_date,
			Date end_auction_date, int original_price, int sell_price, int no_user, int no_category) {
		this.no_article = no_article;
		this.article_name = article_name;
		this.description = description;
		this.start_auction_date = start_auction_date;
		this.end_auction_date = end_auction_date;
		this.original_price = original_price;
		this.sell_price = sell_price;
		this.no_user = no_user;
		this.no_category = no_category;
	}

	//getters et setters
	public int getNo_article() {
		return no_article;
	}

	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}

	public String getArticleName() {
		return article_name;
	}

	public void setArticleName(String article_name) {
		this.article_name = article_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_auction_date() {
		return start_auction_date;
	}

	public void setStart_auction_date(Date start_auction_date) {
		this.start_auction_date = start_auction_date;
	}

	public Date getEnd_auction_date() {
		return end_auction_date;
	}

	public void setEnd_auction_date(Date end_auction_date) {
		this.end_auction_date = end_auction_date;
	}

	public int getOriginal_price() {
		return original_price;
	}

	public void setOriginal_price(int original_price) {
		this.original_price = original_price;
	}

	public int getSell_price() {
		return sell_price;
	}

	public void setSell_price(int sell_price) {
		this.sell_price = sell_price;
	}

	public int getNo_utilisateur() {
		return no_user;
	}

	public void setNo_user(int no_user) {
		this.no_user = no_user;
	}

	public int getNo_category() {
		return no_category;
	}

	public void setNo_category(int no_category) {
		this.no_category = no_category;
	}
	
	
	
}
