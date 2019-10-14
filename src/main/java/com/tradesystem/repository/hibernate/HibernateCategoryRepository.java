package com.tradesystem.repository.hibernate;

import com.tradesystem.config.hibernate.HibernateUtil;
import com.tradesystem.entity.CategoryEntity;
import com.tradesystem.repository.category.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

public class HibernateCategoryRepository extends HibernateCrudRepository<CategoryEntity> implements CategoryRepository {
    @Override
    public CategoryEntity save(CategoryEntity entity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return entity;
    }
}
