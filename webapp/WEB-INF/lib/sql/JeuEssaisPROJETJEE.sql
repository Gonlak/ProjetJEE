-- Insertion des catégories
INSERT INTO CATEGORIES (libelle) VALUES ('Informatique');
INSERT INTO CATEGORIES (libelle) VALUES ('Ameublement');
INSERT INTO CATEGORIES (libelle) VALUES ('Vêtement');
INSERT INTO CATEGORIES (libelle) VALUES ('Sport&Loisirs');

-- Insertion des utilisateurs
INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES ('johndoe', 'Doe', 'John', 'johndoe@example.com', '0606060606', '1 rue des Lilas', '75001', 'Paris', '1234', 1000, 0);
INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES ('janedoe', 'Doe', 'Jane', 'janedoe@example.com', '0707070707', '2 rue des Roses', '75002', 'Paris', '1234', 1200, 0);
INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES ('admin', 'Ad', 'Mine', 'admin@example.com', '0123456789', '1 rue des Admin', '29000', 'Quimper', 'admin', 1200, 1);

-- Insertion des articles vendus
-- Informatique
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Ordinateur portable', 'Ordinateur portable performant', '2023-05-01', '2023-05-10', 500, 700, 1, 1, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Souris sans fil', 'Souris sans fil confortable', '2023-05-01', '2023-05-08', 20, 30, 1, 1, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Clavier mécanique', 'Clavier mécanique RGB', '2023-05-01', '2023-05-09', 80, 100, 1, 1, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Ecran 24 pouces', 'Ecran 24 pouces Full HD', '2023-05-01', '2023-05-12', 100, 130, 2, 1, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Casque audio', 'Casque audio Bluetooth', '2023-05-01', '2023-05-07', 40, 60,2, 1, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Disque dur externe', 'Disque dur externe 1 To', '2023-05-01', '2023-05-11', 50, 75, 2, 1, 1);

-- Ameublement
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Canapé', 'Canapé d''angle convertible', '2023-05-01', '2023-05-10', 400, 550, 1, 2, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Table basse', 'Table basse en bois', '2023-05-01', '2023-05-08', 80, 110, 1, 2, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Chaise', 'Chaise design', '2023-05-01', '2023-05-09', 50, 70, 1, 2, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Bureau', 'Bureau fonctionnel', '2023-05-01', '2023-05-12', 150, 200, 2, 2, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Armoire', 'Armoire en bois massif', '2023-05-01', '2023-05-07', 300, 400, 2, 2, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Étagère', 'Étagère modulable', '2023-05-01', '2023-05-11', 100, 140, 2, 2, 1);

-- Vêtement
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Manteau', 'Manteau d''hiver chaud', '2023-05-01', '2023-05-10', 80, 120, 1, 3, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Robe', 'Robe élégante', '2023-05-01', '2023-05-08', 40, 60, 1, 3, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Chemise', 'Chemise en coton', '2023-05-01', '2023-05-09', 30, 45, 1, 3, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Jean', 'Jean slim confortable', '2023-05-01', '2023-05-12', 50, 70, 2, 3, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Chaussures', 'Chaussures de sport', '2023-05-01', '2023-05-07', 60, 80, 2, 3, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Sac à main', 'Sac à main en cuir', '2023-05-01', '2023-05-11', 100, 140, 2, 3, 1);

-- Sport & Loisirs
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Vélo', 'Vélo de course', '2023-05-01', '2023-05-10', 300, 400, 1, 4, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Tapis de yoga', 'Tapis de yoga épais', '2023-05-01', '2023-05-08', 20, 30, 1, 4, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Ballon de football', 'Ballon de football taille 5', '2023-05-01', '2023-05-09', 15, 20, 1, 4, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Raquette de tennis', 'Raquette de tennis légère', '2023-05-01', '2023-05-12', 70, 100, 2, 4, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Set de fléchettes', 'Set de fléchettes avec cible', '2023-05-01', '2023-05-07', 40, 60, 2, 4, 1);
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES ('Piscine gonflable', 'Piscine gonflable familiale', '2023-05-01', '2023-05-11', 80, 120, 2, 4, 1);

-- Insertion des enchères
INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (1, 1, '2023-05-02', 600);
INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (2, 1, '2023-05-03', 700);
INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (1, 2, '2023-05-02', 25);
INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (2, 2, '2023-05-03', 30);

-- Insertion des retraits
INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (1, '1 rue des Lilas', '75001', 'Paris');
INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (2, '2 rue des Roses', '75002', 'Paris');
INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (3, '1 rue des Lilas', '75001', 'Paris');
INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (4, '2 rue des Roses', '75002', 'Paris');
INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (5, '1 rue des Lilas', '75001', 'Paris');
INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (6, '2 rue des Roses', '75002', 'Paris');