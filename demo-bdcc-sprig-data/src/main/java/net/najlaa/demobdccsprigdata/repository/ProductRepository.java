package net.najlaa.demobdccsprigdata.repository;

import net.najlaa.demobdccsprigdata.entities.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByNameContains(String kw);
}
