package org.eni_encheres.bll;

import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Enchere;
import org.eni_encheres.dal.DAOFactory;

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
        return DAOFactory.getEnchereDAO().selectAll();
    }

    // recup un enchere
    public Enchere getEnchere(int id){
        return DAOFactory.getEnchereDAO().selectById(id);
    }

    // ajoute un enchere
    public void addEnchere(Enchere enchere) throws BLLException {
        // check all fields
        // verifAddArticle(enchere);
        DAOFactory.getEnchereDAO().insert(enchere);
    }

}
