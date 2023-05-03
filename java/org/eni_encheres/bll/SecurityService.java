package org.eni_encheres.bll;


import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.eni_encheres.bll.exception.BLLException;
import org.eni_encheres.bo.Utilisateur;
import org.eni_encheres.dal.DAOFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityService {
    @Getter
    private static SecurityService instance = new SecurityService();// lazy singleton


    public static SecurityService getInstance() {
        return instance;
    }

    public void addUser(Utilisateur utilisateur) {
        utilisateur.setPassword(BCrypt.withDefaults().hashToString(12, utilisateur.getPassword().toCharArray()));
        DAOFactory.getUtilisateurDAO().insert(utilisateur);
    }

    public Utilisateur login(String pseudo, String password) throws BLLException {
        Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().selectByUsername(pseudo);
        if(utilisateur == null){
            throw new BLLException("Utilisateur non trouvé!");
        }
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), utilisateur.getPassword());
        if(!result.verified){
            throw new BLLException("Le mot de passe est eronné");
        }
        return utilisateur;
    }
}
