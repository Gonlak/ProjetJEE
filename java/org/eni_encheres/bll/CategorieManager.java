package org.eni_encheres.bll;

import org.eni_encheres.bo.Categorie;

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
        //return DaoFactory.getCategorieDao().selectAll();
        // Seb a remplasser le return null par celui de haut dessus
        return null;
    }

    // recup une Categorie
    public Categorie getCategorie(int id){
        //return DaoFactory.getCategorieDao().selectOne(id);
        // Seb a remplasser le return null par celui de haut dessus
        return null;
    }

}
