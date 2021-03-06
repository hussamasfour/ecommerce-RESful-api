package com.hussam.inventory.inventory.controllers;

import com.hussam.inventory.inventory.entities.Product;
import com.hussam.inventory.inventory.exception.NotFoundException;
import com.hussam.inventory.inventory.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductByIdFromCategory(@PathVariable("id") Long id, @RequestParam("category") String categoryName) {
        LOGGER.info("Inside getProductByIdFromCategory()");
        Optional<Product> product = productService.getProductByIdAndCategory(id,categoryName);
        if(!product.isPresent()){
            throw new NotFoundException("Product with id: "+ id + " not available");
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Product> addNewProduct(@Valid @RequestBody Product product, @RequestParam("category") String category){
        LOGGER.info("Inside addNewProduct()");
        Product newProduct = productService.add(product, category);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllProductsInSelectedCategory(@RequestParam("category") String categoryName){
        LOGGER.info("Inside getAllProductsInSelectedCategory()");
        List<Product> products = productService.getAllByCategory(categoryName);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
