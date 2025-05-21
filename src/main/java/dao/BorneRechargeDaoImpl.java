package dao;

import model.BorneRecharge;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class BorneRechargeDaoImpl implements BorneRechargeDao {

    @Override
    public void create(BorneRecharge borne) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(borne);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public BorneRecharge findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        BorneRecharge borne = session.get(BorneRecharge.class, id);
        session.close();
        return borne;
    }

    @Override
    public List<BorneRecharge> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<BorneRecharge> query = session.createQuery("from BorneRecharge", BorneRecharge.class);
        List<BorneRecharge> bornes = query.getResultList();
        session.close();
        return bornes;
    }

    @Override
    public void update(BorneRecharge borne) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(borne);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(BorneRecharge borne) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.remove(session.contains(borne) ? borne : session.merge(borne));
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
} 