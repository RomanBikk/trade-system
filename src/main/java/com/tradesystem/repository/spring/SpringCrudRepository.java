package com.tradesystem.repository.spring;
import com.tradesystem.entity.ProductEntity;
import com.tradesystem.model.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SpringCrudRepository extends CrudRepository<Product,Long>, JpaSpecificationExecutor<Product> {

}
