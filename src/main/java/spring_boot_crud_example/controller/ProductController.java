package spring_boot_crud_example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import spring_boot_crud_example.entity.Product;
import spring_boot_crud_example.service.ProductService;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    private Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    private List<Product> addProduct(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    private List<Product> findAllProduct(){
        return productService.getProducts();
    }

    @GetMapping("/product/{id}")
    private Product findProductById( @PathVariable int id){
        return productService.getProductsById(id);
    }

    @GetMapping("/products/{name}")
    private Product findProductByName( @PathVariable String name){
        return  productService.getProductsByName(name);
    }

    @PutMapping("/update")
    private  Product updateProduct(@RequestBody Product product){
        return  productService.updateProducts(product);
    }

   @DeleteMapping("/delete/{id}")
    private String deleteProduct(@PathVariable int id){
        return  productService.deleteProducts(id);
    }


}
