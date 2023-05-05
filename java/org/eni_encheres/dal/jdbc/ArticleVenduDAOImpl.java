package org.eni_encheres.dal.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Categorie;
import org.eni_encheres.bo.Enchere;
import org.eni_encheres.bo.Utilisateur;
import org.eni_encheres.config.ConnectionProvider;
import org.eni_encheres.dal.ArticleVenduDAO;

public class ArticleVenduDAOImpl implements ArticleVenduDAO{

	private final static String SELECT_ALL_CURRENT = "select av.no_article,nom_article,description,date_debut_encheres, "
														+ "date_fin_encheres,prix_initial,prix_vente,etat_vente,pseudo,rue,code_postal, "
														+ "ville,credit,c.no_categorie,libelle,u.no_utilisateur,date_enchere, "
														+ "max(montant_enchere) as montant_max "
														+ "from ARTICLES_VENDUS av "
														+ "inner join ENCHERES e "
														+ "on av.no_article = e.no_article "
														+ "inner join UTILISATEURS u "
														+ "on e.no_utilisateur = u.no_utilisateur "
														+ "inner join CATEGORIES c "
														+ "on av.no_categorie = c.no_categorie "
														+ "WHERE etat_vente = ? "
														+ "group by av.no_article,nom_article,description,date_debut_encheres, "
														+ "date_fin_encheres,prix_initial,prix_vente,etat_vente,pseudo,rue,code_postal, "
														+ "ville,credit,c.no_categorie,libelle,u.no_utilisateur,date_enchere; ";
	
	@Override
	public List<Article_Vendu> selectByKeyWord(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article_Vendu> selectAll() {

		try(Connection connection = ConnectionProvider.getConnection()) {
			List<Article_Vendu> articles = new ArrayList<>();
			List<Enchere> encheres = new ArrayList<>();
			
			
			PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_CURRENT);
			
			stmt.setInt(1,1);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				encheres.add(new Enchere(rs.getDate("date_enchere"),rs.getInt("montant_max")));
				articles.add(new Article_Vendu(
								 rs.getInt("no_article"),
								 rs.getString("nom_article"),
								 rs.getString("description"),
								 rs.getDate("date_debut_encheres"),
								 rs.getDate("date_fin_encheres"),
								 rs.getInt("prix_initial"),
								 rs.getInt("prix_vente"),
							     rs.getInt("etat_vente"),
						 new Utilisateur(
								 rs.getString("pseudo"),
								 rs.getString("rue"),
								 rs.getString("code_postal"),
					             rs.getString("ville"),
                                 rs.getInt("credit")),
						 new Categorie(
								 rs.getInt("no_categorie"),
								 rs.getString("libelle")),
						 encheres));
			}
			return articles;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insert(Article_Vendu article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article_Vendu selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Article_Vendu article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
