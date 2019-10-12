package com.tradesystem.repository.hibernate;

import com.tradesystem.config.hibernate.HibernateUtil;
import com.tradesystem.entity.CategoryEntity;
import com.tradesystem.entity.ProductEntity;
import com.tradesystem.repository.product.ProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

//@Slf4j
public class HibernateProductRepository extends HibernateCrudRepository<ProductEntity> implements ProductRepository {
    @Override
    public ProductEntity save(ProductEntity productEntity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Optional.ofNullable(productEntity.getCategory())
                    .flatMap(category -> Optional.ofNullable(category.getId()))
                    .ifPresent(categoryId -> {
                        CategoryEntity categoryEntity = session.get(CategoryEntity.class, categoryId);
                        productEntity.setCategory(categoryEntity);
                    });
            session.persist(productEntity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return productEntity;
    }


}
