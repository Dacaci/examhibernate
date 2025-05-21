package dao;

import model.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class ReservationDaoImpl implements ReservationDao {

    @Override
    public void create(Reservation reservation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(reservation);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Reservation findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Reservation reservation = session.get(Reservation.class, id);
        session.close();
        return reservation;
    }

    @Override
    public List<Reservation> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Reservation> query = session.createQuery("from Reservation", Reservation.class);
        List<Reservation> reservations = query.getResultList();
        session.close();
        return reservations;
    }

    @Override
    public void update(Reservation reservation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(reservation);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Reservation reservation) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.remove(session.contains(reservation) ? reservation : session.merge(reservation));
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
} 