package org.eni_encheres.bll.exception;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class BLLException extends Exception{
    private List<String> erreurs = new ArrayList<>();

    public BLLException(String message) {
        super(message);
    }

    public void ajouterErreur(String erreur) {
        erreurs.add(erreur);
    }

    @Override
    public String getMessage() {
        return "BLL: "+super.getMessage();
    }
}
