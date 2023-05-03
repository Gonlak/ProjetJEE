package org.eni_encheres.dal;

import java.util.List;


import org.eni_encheres.bo.Utilisateur;

public interface UtilisateurDAO extends DAO<Utilisateur>{
	
	List<Utilisateur> selectByKeyWord(String key);
	
	List<Utilisateur> selectAll();
	
	void insert(Utilisateur utilisateur);

	Utilisateur selectById(int id);

	void update(Utilisateur utilisateur);

	void delete(int id);

	Utilisateur selectByUsername(String pseudo);
}
