package edu.jdc.swll.berld.Berld.repository;

import edu.jdc.swll.berld.Berld.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
