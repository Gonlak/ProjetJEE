package org.eni_encheres.dal.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.eni_encheres.bo.*;
import org.eni_encheres.config.ConnectionProvider;
import org.eni_encheres.dal.ArticleVenduDAO;

public class ArticleVenduDAOImpl implements ArticleVenduDAO {

    // permete de récupérer celle qui non pas d'enchère
    private final static String SELECT_ALL_CURRENT = "SELECT av.no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, u.no_utilisateur, c.no_categorie, etat_vente, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, libelle, date_enchere, montant_enchere "
            + "FROM ARTICLES_VENDUS av "
            + "LEFT OUTER JOIN ENCHERES e ON av.no_article = e.no_article "
            + "INNER JOIN UTILISATEURS u ON u.no_utilisateur = e.no_utilisateur "
            + "INNER JOIN CATEGORIES c ON av.no_categorie = c.no_categorie "
            + "WHERE etat_vente = ? "
            + "GROUP BY av.no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, u.no_utilisateur, c.no_categorie, etat_vente, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur, libelle, date_enchere, montant_enchere;";

    private final static String SELECT_ALL_ARTICLE = "SELECT * FROM ARTICLES_VENDUS av INNER JOIN UTILISATEURS U on U.no_utilisateur = av.no_utilisateur;";

    private final static String SELECT_BY_ID_ENCHER = "SELECT *"
    		+ "FROM RETRAITS r "
    		+ "INNER JOIN ARTICLES_VENDUS av "
    		+ "on r.no_article = av.no_article "
    		+ "INNER JOIN CATEGORIES c "
    		+ "on av.no_categorie = c.no_categorie "
    		+ "INNER JOIN ENCHERES e "
    		+ "on av.no_article = e.no_article "
    		+ "INNER JOIN UTILISATEURS u "
    		+ "on e.no_utilisateur = u.no_utilisateur "
    		+ "WHERE av.no_article = ?;";

    private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, "
            + "prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES(?,?,?,?,?,?,?,?,?);";


    private final static String SELECT_ALL_BY_ID = "select * from UTILISATEURS INNER JOIN ARTICLES_VENDUS AV on UTILISATEURS.no_utilisateur = AV.no_utilisateur where UTILISATEURS.no_utilisateur = ?;";

    private final static String SELECT_BY_CATEGORY_AND_KEYWORD = "SELECT * FROM ARTICLES_VENDUS av "
            + "inner join UTILISATEURS u "
            + "on av.no_utilisateur = u.no_utilisateur "
            + "WHERE nom_article LIKE ? AND no_categorie=?";

    private final static String SELECT_BY_KEYWORD = "SELECT * FROM ARTICLES_VENDUS av "
            + "inner join UTILISATEURS u "
            + "on av.no_utilisateur = u.no_utilisateur "
            + "WHERE nom_article LIKE ?;";
//	  private final static String SELECT_USERNAME_MO = "SELECT umo.pseudo FROM UTILISATEURS umo "
//			  										 + "INNER JOIN ENCHERES e "
//			  										 + "on e.no_utilisateur = umo.no_utilisateur INNER JOIN UTILISATEURS uv "
//			  										 + "on e.no_utilisateur = uv.no_utilisateur INNER JOIN ARTICLES_VENDUS av "
//			  										 + "on e.no_article = av.no_article "
//			  										 + "WHERE av.no_article = ? AND montant_enchere = (SELECT max(montant_enchere) FROM ENCHERES WHERE no_article = ?);";
	  private final static String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS av INNER JOIN UTILISATEURS u ON av.no_utilisateur = u.no_utilisateur WHERE no_article = ?;";


//    @Override
//    public List<Article_Vendu> selectByKeyWord(String key) {
//        // TODO Auto-generated method stub
//        return null;
//    }

    @Override
    public List<Article_Vendu> selectAll() {
        try (Connection connection = ConnectionProvider.getConnection()) {
            List<Article_Vendu> articles = new ArrayList<>();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ARTICLE);

            while (resultSet.next()) {
                articles.add(new Article_Vendu(resultSet.getInt("no_article"),
                        resultSet.getString("nom_article"),
                        resultSet.getString("description"),
                        resultSet.getDate("date_debut_encheres").toLocalDate(),
                        resultSet.getDate("date_fin_encheres").toLocalDate(),
                        resultSet.getInt("prix_initial"),
                        resultSet.getInt("prix_vente"),
                        resultSet.getInt("etat_vente"),
                        new Utilisateur(resultSet.getInt("no_utilisateur"),
                                resultSet.getString("pseudo"),
                                resultSet.getString("nom"),
                                resultSet.getString("prenom"),
                                resultSet.getString("email"),
                                resultSet.getString("telephone"),
                                resultSet.getString("rue"),
                                resultSet.getString("code_postal"),
                                resultSet.getString("ville"),
                                resultSet.getString("mot_de_passe"),
                                resultSet.getInt("credit"),
                                resultSet.getBoolean("administrateur"))));
            }
            return articles;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Article_Vendu> selectAllData() {
        try (Connection connection = ConnectionProvider.getConnection()) {
            List<Article_Vendu> articles = new ArrayList<>();
            List<Enchere> encheres = new ArrayList<>();

            PreparedStatement stmt = connection.prepareStatement(SELECT_ALL_CURRENT);

            stmt.setInt(1, 1);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                encheres.add(new Enchere(rs.getInt("no_utilisateur"), rs.getInt("no_article"), rs.getDate("date_enchere"), rs.getInt("montant_enchere")));
                articles.add(new Article_Vendu(
                        rs.getInt("no_article"),
                        rs.getString("nom_article"),
                        rs.getString("description"),
                        rs.getDate("date_debut_encheres").toLocalDate(),
                        rs.getDate("date_fin_encheres").toLocalDate(),
                        rs.getInt("prix_initial"),
                        rs.getInt("prix_vente"),
                        rs.getInt("etat_vente"),
                        new Utilisateur(
                                rs.getInt("no_utilisateur"),
                                rs.getString("pseudo"),
                                rs.getString("nom"),
                                rs.getString("prenom"),
                                rs.getString("email"),
                                rs.getString("telephone"),
                                rs.getString("rue"),
                                rs.getString("code_postal"),
                                rs.getString("ville"),
                                rs.getString("mot_de_passe"),
                                rs.getInt("credit"),
                                rs.getBoolean("administrateur")),
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
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, article.getArticleName());
            statement.setString(2, article.getDescription());
            statement.setDate(3, Date.valueOf(article.getStart_auction_date()));
            statement.setDate(4, Date.valueOf(article.getEnd_auction_date()));
            statement.setInt(5, article.getOriginal_price());
            statement.setInt(6, article.getSell_price());
            statement.setInt(7, article.getUser().getNo_user());
            statement.setInt(8, article.getCategories().getNo_categorie());
            statement.setInt(9, article.getSale_status());

            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                article.setNo_article(resultSet.getInt(1)); // pour la redirection
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Article_Vendu> selectAllByID(int id) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            List<Article_Vendu> article_vendus = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                article_vendus.add(new Article_Vendu(resultSet.getInt("no_article"), resultSet.getString("nom_article"),
                        resultSet.getString("description"), resultSet.getDate("date_debut_encheres").toLocalDate(), resultSet.getDate("date_fin_encheres").toLocalDate(),
                        resultSet.getInt("prix_initial"), resultSet.getInt("prix_vente"), resultSet.getInt("etat_vente"), new Utilisateur(resultSet.getInt("no_utilisateur"), resultSet.getString("pseudo"),
                        resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getString("email"),
                        resultSet.getString("telephone"), resultSet.getString("rue"), resultSet.getString("code_postal"),
                        resultSet.getString("ville"), resultSet.getString("mot_de_passe"), resultSet.getInt("credit"),
                        resultSet.getBoolean("administrateur"))));
            }
            return article_vendus;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Article_Vendu selectByIdEnchere(int id) {
    	try (Connection connection = ConnectionProvider.getConnection()) {
    		List<Enchere> encheres = new ArrayList<>();

    		PreparedStatement pStmt = connection.prepareStatement(SELECT_BY_ID_ENCHER);
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            if(rs.next()) {
            	return new Article_Vendu(rs.getInt("no_article"),
                        rs.getString("nom_article"),
                        rs.getString("description"),
                        rs.getDate("date_debut_encheres").toLocalDate(),
                        rs.getDate("date_fin_encheres").toLocalDate(),
                        rs.getInt("prix_initial"),
                        rs.getInt("prix_vente"),
                        rs.getInt("etat_vente"),
            			new Utilisateur(rs.getInt("no_utilisateur"),
            					rs.getString("pseudo"),
            					rs.getString("nom"),
            					rs.getString("prenom"),
            					rs.getString("email"),
            					rs.getString("telephone"),
            					rs.getString("rue"),
            					rs.getString("code_postal"),
            					rs.getString("ville"),
            					rs.getString("mot_de_passe"),
            					rs.getInt("credit"),
            					rs.getBoolean("administrateur")),
            				new Categorie(
                                rs.getInt("no_categorie"),
                                rs.getString("libelle")),
            						encheres,
            								new Retrait(rs.getString("rue"),
            											rs.getString("code_postal"),
            											rs.getString("ville")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Article_Vendu selectById(int id) {
    	try (Connection connection = ConnectionProvider.getConnection()) {


    		PreparedStatement pStmt = connection.prepareStatement(SELECT_BY_ID);
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            if(rs.next()) {
            	return new Article_Vendu(rs.getInt("no_article"),
                        rs.getString("nom_article"),
                        rs.getString("description"),
                        rs.getDate("date_debut_encheres").toLocalDate(),
                        rs.getDate("date_fin_encheres").toLocalDate(),
                        rs.getInt("prix_initial"),
                        rs.getInt("prix_vente"),
                        rs.getInt("etat_vente"),
            			new Utilisateur(rs.getInt("no_utilisateur"),
            					rs.getString("pseudo"),
            					rs.getString("nom"),
            					rs.getString("prenom"),
            					rs.getString("email"),
            					rs.getString("telephone"),
            					rs.getString("rue"),
            					rs.getString("code_postal"),
            					rs.getString("ville"),
            					rs.getString("mot_de_passe"),
            					rs.getInt("credit"),
            					rs.getBoolean("administrateur")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
