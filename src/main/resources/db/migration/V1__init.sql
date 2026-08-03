CREATE TABLE client (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nom VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        telephone VARCHAR(50) NOT NULL,
                        ville VARCHAR(100) NOT NULL
);

CREATE TABLE produit (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nom VARCHAR(255) NOT NULL,
                         categorie VARCHAR(100) NOT NULL,
                         prix DOUBLE NOT NULL,
                         quantite INT NOT NULL
);

CREATE TABLE commande (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          date_commande DATE NOT NULL,
                          commande_statut VARCHAR(50) NOT NULL,
                          client_id BIGINT
);

CREATE TABLE ligne_commande (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                quantite INT NOT NULL,
                                produit_id BIGINT,
                                commande_id BIGINT
);

CREATE TABLE user (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              nom VARCHAR(255) NOT NULL,
                              prenom VARCHAR(255) NOT NULL,
                              email VARCHAR(255) NOT NULL UNIQUE,
                              password VARCHAR(255) NOT NULL,
                              role_user VARCHAR(50) NOT NULL
);