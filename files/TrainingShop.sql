----------- Reconstruction de la base de données -----------
DROP DATABASE IF EXISTS TrainingShop;
CREATE DATABASE TrainingShop;
USE TrainingShop;

----------- Construction de la table des formations -----------
CREATE TABLE T_Trainings (
	IdTraining		int(4)			PRIMARY KEY AUTO_INCREMENT,
	Name			varchar(30)		NOT NULL,
	Description		varchar(100)	NOT NULL,
	NbOfDays		int(4)			NOT NULL,
	Localisation	varchar(30)		NOT NULL,
	UnitaryPrice	float(8)		NOT NULL,
	IdCategory		int(4)			NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Trainings ( Name, Description, NbOfDays, Localisation, UnitaryPrice, IdCategory ) VALUES ( 'Java' , 'Java SE 8 : Syntaxe & POO', 20, 'Presentiel', 500, 1);
INSERT INTO T_Trainings ( Name, Description, NbOfDays, Localisation, UnitaryPrice, IdCategory ) VALUES ( 'Java avance' , 'Exceptions, fichiers, Jdbc, thread...', 20, 'Distanciel', 705, 1);
INSERT INTO T_Trainings ( Name, Description, NbOfDays, Localisation, UnitaryPrice, IdCategory ) VALUES ( 'Excel' , 'Integrale', 6, 'Presentiel', 232, 3);
INSERT INTO T_Trainings ( Name, Description, NbOfDays, Localisation, UnitaryPrice, IdCategory ) VALUES ( 'PowerPoint' , 'Integrale', 4, 'Presentiel', 156, 3);
INSERT INTO T_Trainings ( Name, Description, NbOfDays, Localisation, UnitaryPrice, IdCategory ) VALUES ( 'Spring' , 'Spring Core/Mvc/Security', 20, 'Distanciel', 300, 1);
INSERT INTO T_Trainings ( Name, Description, NbOfDays, Localisation, UnitaryPrice, IdCategory ) VALUES ( 'Php frameworks' , 'Symphony', 15, 'Presentiel', 200, 1);
INSERT INTO T_Trainings ( Name, Description, NbOfDays, Localisation, UnitaryPrice, IdCategory ) VALUES ( 'C#' , 'Dotnet Core', 20, 'Distanciel', 500, 1);
INSERT INTO T_Trainings ( Name, Description, NbOfDays, Localisation, UnitaryPrice, IdCategory ) VALUES ( 'Analyste cybersecurite' , 'Config VPN, secu de couche reseau', 140, 'Distanciel', 1500, 5);
INSERT INTO T_Trainings ( Name, Description, NbOfDays, Localisation, UnitaryPrice, IdCategory ) VALUES ( 'Data science avec Python' , 'Intro data science, python...', 3, 'Distanciel', 279, 4);
INSERT INTO T_Trainings ( Name, Description, NbOfDays, Localisation, UnitaryPrice, IdCategory ) VALUES ( 'Wordpress' , 'Presentation du logiciel, gestion de contenu', 3, 'Presentiel', 146, 2);
INSERT INTO T_Trainings ( Name, Description, NbOfDays, Localisation, UnitaryPrice, IdCategory ) VALUES ( 'Data science avec R' , 'Intro machine learning, arbre', 4, 'Distanciel', 894, 4);

----------- Construction de la table des catégories -----------
CREATE TABLE T_Categories (
	IdCategory		int(4)			PRIMARY KEY AUTO_INCREMENT,
	CatName			varchar(30)		NOT NULL,
	Description		varchar(100)	NOT NULL
) ENGINE = InnoDB;
--Insertion des valeurs dans la table T_Categories
INSERT INTO T_Categories ( CatName, Description ) VALUES ( 'Dev Web' , 'Realisation de l''ensemble des fonctionnalites techniques d''un site Internet ou d''une application web' );
INSERT INTO T_Categories ( CatName, Description ) VALUES ( 'Cms' , 'Content Management System' );
INSERT INTO T_Categories ( CatName, Description ) VALUES ( 'Bureautique' , 'Apprentissage des differents logiciels' );
INSERT INTO T_Categories ( CatName, Description ) VALUES ( 'IA ' , 'Creation et application d''algorithmes executes dans un environnement informatique dynamique' );
INSERT INTO T_Categories ( CatName, Description ) VALUES ( 'Cyber securite ' , 'Assurer la protection et integrite des donnees dans une infrastructure numerique' );

ALTER TABLE T_Trainings ADD FOREIGN KEY(IdCategory) REFERENCES T_Categories(IdCategory);

----------- Construction de la table des utilisateurs -----------
CREATE TABLE T_Users (
	IdUser 		int(4) 			PRIMARY KEY AUTO_INCREMENT,
	Login 		varchar(20)	 	NOT NULL unique,
	Password 	varchar(20) 	NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Users ( Login, Password) VALUES ( 'RoRy' , 'K20wA03k09');
INSERT INTO T_Users ( Login, Password) VALUES ( 'Gwen' , 'n061N861b');
INSERT INTO T_Users ( Login, Password) VALUES ( 'LadyHead' , 'Al06pH03sE85');

----------- Construction de la table des clients -----------
CREATE TABLE T_Customers (
	IdCustomer		int(4) 	PRIMARY KEY AUTO_INCREMENT,
	Name			varchar(30)		NOT NULL,
	Firstname		varchar(30)		NOT NULL,
	email			varchar(30)		NOT NULL unique,
	adress			varchar(50)		,
	phone			varchar(30)		,
	IdUser			int(4)			NOT NULL,
	FOREIGN KEY(idUser) 	REFERENCES T_Users(idUser)
)ENGINE = InnoDB;

----------- Construction de la table des commandes -----------
CREATE TABLE T_Orders (
	IdOrder 		int(4) 			PRIMARY KEY AUTO_INCREMENT,
	Amount 			float(4)	 	NOT NULL default 0,
	DateOrder 		varchar(20) 	NOT NULL default now(),
	IdCustomer		int(4)			not null,
	FOREIGN KEY(idCustomer)		REFERENCES T_Customers(idCustomer)
) ENGINE = InnoDB;

----------- Construction de la table du panier -----------
CREATE TABLE T_OrderTraining (
	IdOrderTraining 			int(4) 		PRIMARY KEY AUTO_INCREMENT,
	IdTraining		int(4)		not null,
	FOREIGN KEY(idTraining)		REFERENCES T_Trainings(idTraining),
	Quantity		float(4)	not null default 0,
	UnitaryPrice	float(4)	not null default 0,
	IdOrder 		int(4)		not null,
	FOREIGN KEY(idOrder)		REFERENCES T_Orders(idOrder)
) ENGINE = InnoDB;