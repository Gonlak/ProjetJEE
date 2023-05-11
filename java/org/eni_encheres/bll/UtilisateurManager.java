package org.eni_encheres.bll;

import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Article_Vendu;
import org.eni_encheres.bo.Utilisateur;
import org.eni_encheres.dal.DAOFactory;

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
        return DAOFactory.getUtilisateurDAO().selectAll();
    }

    // recup un utilisateur
    public Utilisateur getUtilisateur(int id){
        return DAOFactory.getUtilisateurDAO().selectById(id);
    }
    
    // recuperer l'utilisateur qui a fait la meilleure offre
    public Utilisateur getUtilisateurMo(int id) {
    	return DAOFactory.getUtilisateurDAO().selectUsernameMo(id);
    }

    // ajoute un utilisateur
    public void addUtilisateur(Utilisateur utilisateur) throws BLLException {
        // check all fields
        // verifAddUtilisateur(utilisateur);
        DAOFactory.getUtilisateurDAO().insert(utilisateur);
    }

    //debiter un utilisateur
    public void debiterUtilisateur(Utilisateur id, int credit) {
    	DAOFactory.getUtilisateurDAO().debiter(id, credit);
    }
    
    //crediter un utilisateur
    public void crediterUtilisateur(Utilisateur id, int credit) {
    	DAOFactory.getUtilisateurDAO().crediter(id, credit);
    }
}
