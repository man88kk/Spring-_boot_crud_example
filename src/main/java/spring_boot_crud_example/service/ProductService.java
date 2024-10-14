package spring_boot_crud_example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_boot_crud_example.entity.Product;
import spring_boot_crud_example.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
       return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    public List<Product>  getProducts(){
        return repository.findAll();
    }

    public  Product  getProductsById(int id){
        return repository.findById(id).orElse(null);

    }

    public  Product  getProductsByName(String name){
        return repository.findByName(name);
    }

    public  String  deleteProducts(int id){
        repository.deleteById(id);
        return  "product removed"+ id;
    }

    public Product  updateProducts(Product product){
        Product existingProduct= repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
         return  repository.save(existingProduct);
    }


}