package org.eni_encheres.bll;

import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Categorie;
import org.eni_encheres.dal.DAOFactory;

import java.util.List;

public class CategorieManager {
    // Singleton
    //1
    private static CategorieManager instance;
    //2
    private CategorieManager(){}
    //3
    public static CategorieManager getInstance(){
        if (instance == null){
            instance = new CategorieManager();
        }
        return instance;
    }

    // get all Categorie
    public List<Categorie> getAllCategorie(){
        return DAOFactory.getCategorieDAO().selectAll();
    }

    // recup une Categorie
    public Categorie getCategorie(int id){
        return DAOFactory.getCategorieDAO().selectById(id);
    }
    
}
