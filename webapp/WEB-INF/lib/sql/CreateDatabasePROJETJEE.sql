

-- SUPPRIME TOUT LES TABLE
IF OBJECT_ID('ENCHERES', 'U') IS NOT NULL
    ALTER TABLE ENCHERES DROP CONSTRAINT encheres_utilisateur_fk, encheres_articles_vendus_fk;
IF OBJECT_ID('RETRAITS', 'U') IS NOT NULL
    ALTER TABLE RETRAITS DROP CONSTRAINT retraits_articles_vendus_fk;
IF OBJECT_ID('ARTICLES_VENDUS', 'U') IS NOT NULL
    ALTER TABLE ARTICLES_VENDUS DROP CONSTRAINT articles_vendus_categories_fk, ventes_utilisateur_fk;
IF OBJECT_ID('UTILISATEURS', 'U') IS NOT NULL
    ALTER TABLE UTILISATEURS DROP CONSTRAINT utilisateur_pk, utilisateurs_un;

IF OBJECT_ID('ENCHERES', 'U') IS NOT NULL
    DROP TABLE ENCHERES;
IF OBJECT_ID('RETRAITS', 'U') IS NOT NULL
    DROP TABLE RETRAITS;
IF OBJECT_ID('UTILISATEURS', 'U') IS NOT NULL
    DROP TABLE UTILISATEURS;
IF OBJECT_ID('CATEGORIES', 'U') IS NOT NULL
    DROP TABLE CATEGORIES;
IF OBJECT_ID('ARTICLES_VENDUS', 'U') IS NOT NULL
    DROP TABLE ARTICLES_VENDUS;

-- CREER TOUT LES TABLE

CREATE TABLE CATEGORIES (
    no_categorie   INTEGER IDENTITY(1,1) NOT NULL,
    libelle        VARCHAR(30) NOT NULL
)



ALTER TABLE CATEGORIES ADD constraint categorie_pk PRIMARY KEY (no_categorie)



CREATE TABLE ENCHERES (
    no_utilisateur   INTEGER NOT NULL,
    no_article       INTEGER NOT NULL,
    date_enchere     datetime NOT NULL,
    montant_enchere  INTEGER NOT NULL



)



ALTER TABLE ENCHERES ADD constraint enchere_pk PRIMARY KEY (no_utilisateur, no_article)



CREATE TABLE RETRAITS (
    no_article         INTEGER NOT NULL,
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(15) NOT NULL,
    ville            VARCHAR(30) NOT NULL
)



ALTER TABLE RETRAITS ADD constraint retrait_pk PRIMARY KEY  (no_article)



CREATE TABLE UTILISATEURS (
    no_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
    pseudo           VARCHAR(30) NOT NULL,
    nom              VARCHAR(30) NOT NULL,
    prenom           VARCHAR(30) NOT NULL,
    email            VARCHAR(40) NOT NULL,
    telephone        VARCHAR(15),
    rue              VARCHAR(30) NOT NULL,
    code_postal      VARCHAR(10) NOT NULL,
    ville            VARCHAR(30) NOT NULL,
    mot_de_passe     VARCHAR(255) NOT NULL,
    credit           INTEGER NOT NULL,
    administrateur   bit NOT NULL
)



ALTER TABLE UTILISATEURS ADD constraint utilisateur_pk PRIMARY KEY (no_utilisateur)



ALTER TABLE UTILISATEURS ADD constraint utilisateurs_un UNIQUE (pseudo,email)




CREATE TABLE ARTICLES_VENDUS (
    no_article                    INTEGER IDENTITY(1,1) NOT NULL,
    nom_article                   VARCHAR(30) NOT NULL,
    description                   VARCHAR(300) NOT NULL,
    date_debut_encheres           DATE NOT NULL,
    date_fin_encheres             DATE NOT NULL,
    prix_initial                  INTEGER,
    prix_vente                    INTEGER,
    no_utilisateur                INTEGER NOT NULL,
    no_categorie                  INTEGER NOT NULL,
    etat_vente                    INTEGER NOT NULL
)



ALTER TABLE ARTICLES_VENDUS ADD constraint articles_vendus_pk PRIMARY KEY (no_article)



ALTER TABLE ARTICLES_VENDUS ADD constraint check_etat_vente CHECK (etat_vente in (0 , 1, 2))
--0 = terminé, 1 = en cours, 2 = annulé




ALTER TABLE ENCHERES
    ADD CONSTRAINT encheres_utilisateur_fk FOREIGN KEY ( no_utilisateur ) REFERENCES UTILISATEURS ( no_utilisateur )
ON DELETE NO ACTION
    ON UPDATE no action



ALTER TABLE ENCHERES
    ADD CONSTRAINT encheres_articles_vendus_fk FOREIGN KEY ( no_article )
        REFERENCES ARTICLES_VENDUS ( no_article )
ON DELETE NO ACTION
    ON UPDATE no action



ALTER TABLE RETRAITS
    ADD CONSTRAINT retraits_articles_vendus_fk FOREIGN KEY ( no_article )
        REFERENCES ARTICLES_VENDUS ( no_article )
ON DELETE NO ACTION
    ON UPDATE no action



ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT articles_vendus_categories_fk FOREIGN KEY ( no_categorie )
        REFERENCES categories ( no_categorie )
ON DELETE NO ACTION
    ON UPDATE no action



ALTER TABLE ARTICLES_VENDUS
    ADD CONSTRAINT ventes_utilisateur_fk FOREIGN KEY ( no_utilisateur )
        REFERENCES utilisateurs ( no_utilisateur )
ON DELETE NO ACTION
    ON UPDATE no action


