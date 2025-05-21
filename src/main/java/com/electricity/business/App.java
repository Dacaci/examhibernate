package com.electricity.business;

import dao.*;
import model.*;
import util.HibernateUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // DAO
        UtilisateurDao utilisateurDao = new UtilisateurDaoImpl();
        LieuRechargeDao lieuDao = new LieuRechargeDaoImpl();
        BorneRechargeDao borneDao = new BorneRechargeDaoImpl();
        ReservationDao reservationDao = new ReservationDaoImpl();

        // utilisateur
        Utilisateur user = new Utilisateur();
        user.setEmail("test@exemple.com");
        user.setMotDePasse("1234");
        user.setCodeValidation("ABCD");
        user.setValide(true);
        user.setRole("CLIENT");
        utilisateurDao.create(user);

        // lieu
        LieuRecharge lieu = new LieuRecharge();
        lieu.setNom("Parking Centre");
        lieu.setAdresse("1 rue de la Paix");
        lieuDao.create(lieu);

        // borne
        BorneRecharge borne = new BorneRecharge();
        borne.setEtat("LIBRE");
        borne.setTarifHoraire(new BigDecimal("2.5"));
        borne.setLieu(lieu);
        borneDao.create(borne);

        // réservation
        Reservation reservation = new Reservation();
        reservation.setDateDebut(LocalDateTime.now());
        reservation.setDateFin(LocalDateTime.now().plusHours(2));
        reservation.setStatut("CONFIRMEE");
        reservation.setUtilisateur(user);
        reservation.setBorne(borne);
        reservationDao.create(reservation);

        // affichage
        List<Utilisateur> utilisateurs = utilisateurDao.findAll();
        System.out.println("Utilisateurs : " + utilisateurs);
        List<LieuRecharge> lieux = lieuDao.findAll();
        System.out.println("Lieux : " + lieux);
        List<BorneRecharge> bornes = borneDao.findAll();
        System.out.println("Bornes : " + bornes);
        List<Reservation> reservations = reservationDao.findAll();
        System.out.println("Réservations : " + reservations);

        HibernateUtil.shutdown();
    }
} 