package org.eni_encheres.bo;

import java.sql.Date;
import java.util.List;

public class Article_Vendu {

	//attributs
	private int no_article;
	private String article_name;
	private String description;
	private Date start_auction_date;
	private Date end_auction_date;
	private int original_price;
	private int sell_price;
	private int sale_status; //0 = terminé, 1 = en cours, 2 = annulé
	private Utilisateur user;
	private Categorie categories;
	private List<Enchere> encheres;
	private Retrait retrait;
	
	//constructeurs
	public Article_Vendu() {}
	
	public Article_Vendu(int no_article, String article_name, String description, Date start_auction_date,
			Date end_auction_date, int original_price, int sell_price, int sale_status,Utilisateur  user,
			Categorie categories,List<Enchere> encheres,Retrait retrait) {
		this.no_article = no_article;
		this.article_name = article_name;
		this.description = description;
		this.start_auction_date = start_auction_date;
		this.end_auction_date = end_auction_date;
		this.original_price = original_price;
		this.sell_price = sell_price;
		this.sale_status = sale_status;
		this.user = user;
		this.categories = categories;
		this.encheres = encheres;
		this.retrait = retrait;
	}

	public Article_Vendu(String article_name, String description, Date start_auction_date,
			Date end_auction_date, int original_price, int sell_price, int sale_status,Utilisateur user,
			Categorie categories,List<Enchere> encheres,Retrait retrait) {
		this.article_name = article_name;
		this.description = description;
		this.start_auction_date = start_auction_date;
		this.end_auction_date = end_auction_date;
		this.original_price = original_price;
		this.sell_price = sell_price;
		this.sale_status = sale_status;
		this.user = user;
		this.categories = categories;
		this.encheres = encheres;
		this.retrait = retrait;
	}

	
	
	public Article_Vendu(int no_article, String article_name, String description, Date start_auction_date,
			Date end_auction_date, int original_price, int sell_price, int sale_status, Utilisateur user,
			Categorie categories,List<Enchere> encheres) {
		this.no_article = no_article;
		this.article_name = article_name;
		this.description = description;
		this.start_auction_date = start_auction_date;
		this.end_auction_date = end_auction_date;
		this.original_price = original_price;
		this.sell_price = sell_price;
		this.sale_status = sale_status;
		this.user = user;
		this.categories = categories;
		this.encheres = encheres;
	}
	
	
	
	public Article_Vendu(int no_article, String article_name, String description, Date start_auction_date,
			Date end_auction_date, int original_price, int sell_price, int sale_status, Categorie categories) {
		this.no_article = no_article;
		this.article_name = article_name;
		this.description = description;
		this.start_auction_date = start_auction_date;
		this.end_auction_date = end_auction_date;
		this.original_price = original_price;
		this.sell_price = sell_price;
		this.sale_status = sale_status;
		this.categories = categories;
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

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur  user) {
		this.user = user;
	}

	public Categorie getCategories() {
		return categories;
	}

	public void setCategories(Categorie categories) {
		this.categories = categories;
	}

	public int getSale_status() {
		return sale_status;
	}

	public void setSale_status(int sale_status) {
		this.sale_status = sale_status;
	}

	public List<Enchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	
	
	
	
}
