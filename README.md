# Electricity Business – Java Hibernate 

## Description de l'implémentation
Application de gestion de bornes de recharge électrique avec persistance en base de données via Hibernate.

## Choix techniques
- Base de données : H2 (embarquée)
- Java 20+
- Hibernate 6
- Annotations JPA uniquement
- Aucune bibliothèque externe autre qu'Hibernate

## Fonctionnalités DAO implémentées
Pour chaque entité (Utilisateur, LieuRecharge, BorneRecharge, Reservation) :
- Création
- Lecture par identifiant
- Lecture de tous
- Mise à jour
- Suppression

## Résultat attendu des méthodes DAO testées

Utilisateurs : [Utilisateur{id=1, email='test@exemple.com', role='CLIENT'}]
Lieux : [LieuRecharge{id=1, nom='Parking Centre', adresse='1 rue de la Paix'}]
Bornes : [BorneRecharge{id=1, etat='LIBRE', tarifHoraire=2.5, lieu='Parking Centre'}]
Réservations : [Reservation{id=1, dateDebut=..., dateFin=..., statut='CONFIRMEE', utilisateur='test@exemple.com', borne=1}]


## Lancer le projet
1. Ouvre PowerShell et navigue jusqu'au dossier du projet :
   bash
   cd C:\ElectricityBusiness
   
2.
   mvn clean compile exec:java
   

## 
Ali Moussa Bilel