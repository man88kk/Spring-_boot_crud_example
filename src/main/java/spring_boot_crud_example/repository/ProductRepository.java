package spring_boot_crud_example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_boot_crud_example.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);


}
