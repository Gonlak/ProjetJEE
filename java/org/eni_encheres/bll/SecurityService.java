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

    public void addUser(Utilisateur utilisateur, String passwordConf) throws BLLException {
        checkAddUtilisateur(utilisateur, passwordConf);
        utilisateur.setPassword(BCrypt.withDefaults().hashToString(12, utilisateur.getPassword().toCharArray()));
        DAOFactory.getUtilisateurDAO().insert(utilisateur);
    }

    public void editUser(Utilisateur utilisateur, String passwordModif, String passwordConf, Utilisateur utilisateurC) throws BLLException {
        checkEditUtilisateur(utilisateur, passwordModif, passwordConf, utilisateurC);
        if (passwordModif != null){
            utilisateur.setPassword(BCrypt.withDefaults().hashToString(12, utilisateur.getPassword().toCharArray()));
            DAOFactory.getUtilisateurDAO().update(utilisateur, utilisateurC.getUsername());
        }else {
            utilisateur.setPassword(BCrypt.withDefaults().hashToString(12, passwordModif.toCharArray()));
            DAOFactory.getUtilisateurDAO().update(utilisateur, utilisateurC.getUsername());
        }
    }

    public void deleteUser(Utilisateur utilisateurC){
        DAOFactory.getUtilisateurDAO().delete(utilisateurC.getNo_user());
    }

    public Utilisateur login(String pseudo, String password) throws BLLException {
        BLLException bll = new BLLException("Utilisateur non trouvé!");
        checkUtilisateur(pseudo, password);
        Utilisateur utilisateur = DAOFactory.getUtilisateurDAO().selectByUsername(pseudo);
        if (utilisateur == null) {
            bll = new BLLException("Utilisateur non trouvé!");
            bll.ajouterErreur("Utilisateur non trouvé!");
            throw bll;
        }
        checkPassword(password, pseudo, bll);
        messageError(bll);
        return utilisateur;
    }

    private void checkAddUtilisateur(Utilisateur utilisateur, String passwordConf) throws BLLException {
        BLLException bll = new BLLException("Utilisateur non trouvé!");
        Utilisateur utilisateurCheck = DAOFactory.getUtilisateurDAO().selectByUsername(utilisateur.getUsername());
        if (utilisateurCheck != null){
            bll.ajouterErreur("Le pseudo est déjà pris!");
        }
        utilisateurCheck = DAOFactory.getUtilisateurDAO().selectByUsername(utilisateur.getEmail());
        if (utilisateurCheck != null){
            bll.ajouterErreur("L'Email est déjà pris!");
        }
        checkFiled(utilisateur.getUsername(), "Pseudo", bll);
        checkFiled(utilisateur.getLastname(), "Nom", bll);
        checkFiled(utilisateur.getFirstname(), "Prénom", bll);
        checkFiled(utilisateur.getEmail(), "Email", bll);
        checkFiled(utilisateur.getPhoneNumber(), "Téléphone", bll);
        checkFiled(utilisateur.getStreet(), "Ville", bll);
        checkFiled(utilisateur.getZipCode(), "Code Postale", bll);
        checkFiled(utilisateur.getTown(), "Rue", bll);
        checkFiled(utilisateur.getPassword(), "Mot de passe", bll);
        checkPasswordEquals(utilisateur.getPassword(), passwordConf, bll);
        messageError(bll);
    }


    private void checkEditUtilisateur(Utilisateur utilisateur, String passwordModif, String passwordConf, Utilisateur utilisateurC) throws BLLException {
        BLLException bll = new BLLException("Utilisateur non trouvé!");
        Utilisateur utilisateurCheck = DAOFactory.getUtilisateurDAO().selectByUsername(utilisateurC.getUsername());
        BCrypt.Result result = BCrypt.verifyer().verify(utilisateurC.getPassword().toCharArray(), utilisateurCheck.getPassword());
        if (!result.verified) {
            bll.ajouterErreur("Le mot de passe est eronné!");
        }
        utilisateurCheck = DAOFactory.getUtilisateurDAO().selectByUsername(utilisateur.getUsername());
        if (utilisateurCheck != null && !utilisateurCheck.getUsername().equals(utilisateurC.getUsername())){
            bll.ajouterErreur("Le pseudo est déjà pris!");
        }
        utilisateurCheck = DAOFactory.getUtilisateurDAO().selectByUsername(utilisateur.getEmail());
        if (utilisateurCheck != null && !utilisateurCheck.getEmail().equals(utilisateurC.getEmail())){
            bll.ajouterErreur("L'Email est déjà pris!");
        }
        checkFiled(utilisateur.getUsername(), "Pseudo", bll);
        checkFiled(utilisateur.getLastname(), "Nom", bll);
        checkFiled(utilisateur.getFirstname(), "Prénom", bll);
        checkFiled(utilisateur.getEmail(), "Email", bll);
        checkFiled(utilisateur.getPhoneNumber(), "Téléphone", bll);
        checkFiled(utilisateur.getStreet(), "Ville", bll);
        checkFiled(utilisateur.getZipCode(), "Code Postale", bll);
        checkFiled(utilisateur.getTown(), "Rue", bll);
        checkPasswordEquals(passwordModif, passwordConf, bll);
        messageError(bll);
    }

    private void checkUtilisateur(String pseudo, String password) throws BLLException {
        BLLException bll = new BLLException("Utilisateur non trouvé!");
        checkFiled(pseudo, "Pseudo", bll);
        checkFiled(password, "Mot de passe", bll);
        if (bll.getErreurs().size() > 0) {
            throw bll;
        }
    }

    private void checkFiled(String field, String name, BLLException bll) {
        if (field.isBlank()) {
            bll.ajouterErreur("Le champs " + name + " ne peut pas etre vide!");
        }
    }

    private void checkPassword(String password, String pseudo, BLLException bll) {
        Utilisateur utilisateurCheck = DAOFactory.getUtilisateurDAO().selectByUsername(pseudo);
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), utilisateurCheck.getPassword());

        if (password.isBlank()) {
            bll.ajouterErreur("Le Mot de passe est vide");
        } else if (!result.verified) {
            bll.ajouterErreur("Le mot de passe est eronné!");
        }
    }

    private void checkPasswordEquals(String password, String passwordConf, BLLException bll) {
        if (password.isBlank()) {
            //bll.ajouterErreur("Le Mot de passe est vide");
        } else if (!password.equals(passwordConf)) {
            bll.ajouterErreur("Le Mot de passe n'est pas le même que le mot de passe Confirme");
        }
    }

    private void messageError(BLLException bll) throws BLLException {
        if (bll.getErreurs().size() > 0) {
            throw bll;
        }
    }
}
