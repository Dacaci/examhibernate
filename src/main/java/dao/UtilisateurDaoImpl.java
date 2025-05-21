package dao;

import model.Utilisateur;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class UtilisateurDaoImpl implements UtilisateurDao {

    @Override
    public void create(Utilisateur utilisateur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(utilisateur);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Utilisateur findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Utilisateur utilisateur = session.get(Utilisateur.class, id);
        session.close();
        return utilisateur;
    }

    @Override
    public List<Utilisateur> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Utilisateur> query = session.createQuery("from Utilisateur", Utilisateur.class);
        List<Utilisateur> utilisateurs = query.getResultList();
        session.close();
        return utilisateurs;
    }

    @Override
    public void update(Utilisateur utilisateur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(utilisateur);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Utilisateur utilisateur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.remove(session.contains(utilisateur) ? utilisateur : session.merge(utilisateur));
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
} 