INSERT INTO CATEGORIES (libelle)
VALUES ('Electronique'), ('Vêtements'), ('Mobilier'), ('Livres'), ('Sport'), ('Jouets'), ('Informatique'), ('Musique'), ('Voyages'), ('Beauté et santé');

INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)
VALUES ('jdupont', 'Dupont', 'Jean', 'jdupont@example.com', '0612345678', '3 rue des Fleurs', '75001', 'Paris', 'mdp123', 5000, 0),
       ('mleroy', 'Leroy', 'Marie', 'mleroy@example.com', '0698765432', '10 avenue de la République', '69001', 'Lyon', 'mdp1234', 3500, 0),
       ('admin', 'Admin', 'Super', 'admin@example.com', '0611111111', '1 place de la Liberté', '13001', 'Marseille', 'admin123', 10000, 1);

INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)
VALUES ('iPhone 12', 'iPhone 12 64Go, neuf', '2023-05-01', '2023-05-10', 800, 0, 1, 1),
       ('Chemise', 'Chemise bleue, taille M', '2023-05-02', '2023-05-12', 30, 0, 2, 2),
       ('Canapé', 'Canapé d''angle, 5 places', '2023-05-04', '2023-05-14', 500, 0, 1, 3);

INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere)
VALUES (2, 1, '2023-05-02 10:00:00', 820),
       (1, 2, '2023-05-03 14:30:00', 35),
       (2, 3, '2023-05-05 18:45:00', 550);

INSERT INTO RETRAITS (no_article, rue, code_postal, ville)
VALUES (1, '4 rue de la Paix', '75001', 'Paris'),
       (2, '25 avenue du Général Leclerc', '69001', 'Lyon'),
       (3, '18 boulevard des Lices', '13001', 'Marseille');