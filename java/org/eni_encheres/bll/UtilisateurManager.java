package org.eni_encheres.bll;

import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Utilisateur;

import java.util.List;

public class UtilisateurManager {
    // Singleton
    //1
    private static UtilisateurManager instance;
    //2
    private UtilisateurManager(){}
    //3
    public static UtilisateurManager getInstance(){
        if (instance == null){
            instance = new UtilisateurManager();
        }
        return instance;
    }

    // get all utilisateur
    public List<Utilisateur> getAllUtilisateur(){
        //return DaoFactory.getUtilisateur().selectAll();
        // Seb a remplasser le return null par celui de haut dessus
        return null;
    }

    // recup un utilisateur
    public Utilisateur getUtilisateur(int id){
        //return DaoFactory.getUtilisateurDao().selectOne(id);
        // Seb a remplasser le return null par celui de haut dessus
        return null;
    }

    // ajoute un utilisateur
    public void addUtilisateur(Utilisateur utilisateur) throws BLLException {
        // check all fields
        // verifAddUtilisateur(utilisateur);
        //DaoFactory.getUtilisateurDao().insert(utilisateur);
    }

}
