package dao;

import model.LieuRecharge;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class LieuRechargeDaoImpl implements LieuRechargeDao {

    @Override
    public void create(LieuRecharge lieu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(lieu);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public LieuRecharge findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        LieuRecharge lieu = session.get(LieuRecharge.class, id);
        session.close();
        return lieu;
    }

    @Override
    public List<LieuRecharge> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<LieuRecharge> query = session.createQuery("from LieuRecharge", LieuRecharge.class);
        List<LieuRecharge> lieux = query.getResultList();
        session.close();
        return lieux;
    }

    @Override
    public void update(LieuRecharge lieu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(lieu);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(LieuRecharge lieu) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.remove(session.contains(lieu) ? lieu : session.merge(lieu));
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
} 