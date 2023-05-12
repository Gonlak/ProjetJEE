package org.eni_encheres.dal.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.eni_encheres.bo.*;
import org.eni_encheres.config.ConnectionProvider;
import org.eni_encheres.dal.EnchereDAO;


public class EnchereDAOImpl implements EnchereDAO {

    private static final String SELECT_ALL_AUCTIONS = "SELECT * FROM encheres;";

    private static final String SELECT_ALL_ENCHERES_BY_ID_ARTICLE = "SELECT * FROM ENCHERES "
            + "INNER JOIN ARTICLES_VENDUS AV on AV.no_article = ENCHERES.no_article "
            + "WHERE AV.no_article = ?;";

    @Override
    public List<Enchere> selectByKeyWord(String key) {
        return null;
    }

    @Override
    public List<Enchere> selectAll() {

        try (Connection connection = ConnectionProvider.getConnection()) {
            List<Enchere> encheres = new ArrayList<>();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_AUCTIONS);

            while (resultSet.next()) {
                encheres.add(new Enchere(resultSet.getInt("no_utilisateur"),
                        resultSet.getInt("no_article"),
                        resultSet.getDate("date_enchere").toLocalDate(),
                        resultSet.getInt("montant_enchere")));
            }
            return encheres;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Enchere enchere) {
        // TODO Auto-generated method stub

    }

    @Override
    public Enchere selectById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Enchere> selectAllByIdArticle(int id) {
        List<Enchere> encheres = new ArrayList<>();
        try (Connection connection = ConnectionProvider.getConnection()) {

            PreparedStatement pStmt = connection.prepareStatement(SELECT_ALL_ENCHERES_BY_ID_ARTICLE);
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                encheres.add(new Enchere(rs.getInt("no_utilisateur"), rs.getInt("no_article"),
                        rs.getDate("date_enchere").toLocalDate(), rs.getInt("montant_enchere"),
                        new Article_Vendu(rs.getInt("no_article"),
                                rs.getString("nom_article"),
                                rs.getString("description"),
                                rs.getDate("date_debut_encheres").toLocalDate(),
                                rs.getDate("date_fin_encheres").toLocalDate(),
                                rs.getInt("prix_initial"),
                                rs.getInt("prix_vente"),
                                rs.getInt("etat_vente"))));
            }
            return encheres;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Enchere enchere) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub

    }


}
