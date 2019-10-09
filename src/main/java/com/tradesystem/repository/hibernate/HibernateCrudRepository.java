package com.tradesystem.repository.hibernate;

import com.tradesystem.config.hibernate.HibernateUtil;
import com.tradesystem.entity.ProductEntity;
import com.tradesystem.util.TradeSystemUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class HibernateCrudRepository<T> {

    private Class<T> parameterizedTypeClass = TradeSystemUtil.getGenericTypeClassFromObjectByIndex(this,0);;

    public T save(T t) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            HibernateUtil.getSessionFactory().getCurrentSession().save(t);
            transaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();

        }
        return t;
    }

    public List<T> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(parameterizedTypeClass);
        cq.from(parameterizedTypeClass);
        List<T> result = session.createQuery(cq).getResultList();
        transaction.commit();
        return result;
    }



}
