package com.tradesystem.repository.hibernate;

import com.tradesystem.entity.ProductEntity;
import com.tradesystem.repository.product.ProductRepository;

//@Slf4j
public class HibernateProductRepository extends HibernateCrudRepository<ProductEntity> implements ProductRepository {


}
