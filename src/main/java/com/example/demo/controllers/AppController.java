package com.example.demo.controllers;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDto;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
    @Autowired
    ProductService productService;
    @PostMapping("/products")
    public ResponseEntity addProduct(@RequestBody Product p){
        productService.addProduct(p);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/products/{productName}")
    public ResponseEntity deleteProduct(@PathVariable String productName){
        productService.deleteByName(productName);
        return new ResponseEntity(HttpStatus.OK);
    };
    @GetMapping("/products")
    public ResponseEntity<ProductDto>getProductsList(){
        ProductDto products =productService.getAllProducts();
        return new ResponseEntity(products,HttpStatus.OK);
    }
    @GetMapping("/products/{productName}/{budget}/{exchange}")
    public ResponseEntity<ProductDto>calcMaxProducts(@PathVariable String productName,@PathVariable int budget,@PathVariable int exchange){
        int products =productService.calcMaxProducts(productName,budget,exchange);
        return new ResponseEntity(products,HttpStatus.OK);
    }
}
