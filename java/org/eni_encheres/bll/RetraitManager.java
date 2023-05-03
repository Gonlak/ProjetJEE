package org.eni_encheres.bll;

import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Retrait;

import java.util.List;

public class RetraitManager {
    // Singleton
    //1
    private static RetraitManager instance;
    //2
    private RetraitManager(){}
    //3
    public static RetraitManager getInstance(){
        if (instance == null){
            instance = new RetraitManager();
        }
        return instance;
    }

    // get all retrait
    public List<Retrait> getAllRetrait(){
        //return DaoFactory.getRetraitDao().selectAll();
        // Seb a remplasser le return null par celui de haut dessus
        return null;
    }

    // recup un retrait
    public Retrait getRetrait(int id){
        //return DaoFactory.getRetraitDao().selectOne(id);
        // Seb a remplasser le return null par celui de haut dessus
        return null;
    }

    // ajoute un retrait
    public void addRetrait(Retrait retrait) throws BLLException {
        // check all fields
        // verifAddRetrait(retrait);
        //DaoFactory.getRetraitDao().insert(retrait);
    }

}
