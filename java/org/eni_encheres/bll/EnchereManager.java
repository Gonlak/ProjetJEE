package org.eni_encheres.bll;

import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Enchere;

import java.util.List;

public class EnchereManager {
    // Singleton
    //1
    private static EnchereManager instance;
    //2
    private EnchereManager(){}
    //3
    public static EnchereManager getInstance(){
        if (instance == null){
            instance = new EnchereManager();
        }
        return instance;
    }

    // get all enchere
    public List<Enchere> getAllEnchere(){
        //return DaoFactory.getEncheresDao().selectAll();
        // Seb a remplasser le return null par celui de haut dessus
        return null;
    }

    // recup un enchere
    public Enchere getEnchere(int id){
        //return DaoFactory.getEncheresDao().selectOne(id);
        // Seb a remplasser le return null par celui de haut dessus
        return null;
    }

    // ajoute un enchere
    public void addEnchere(Enchere enchere) throws BLLException {
        // check all fields
        // verifAddArticle(enchere);
        //DaoFactory.getEncheresDao().insert(enchere);
    }

}
