package com.example.demo.services;

import com.example.demo.dao.ProductDAO;
import com.example.demo.model.Product;
import com.example.demo.model.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDAO productDAO;
    public void addProduct(Product p) {
        productDAO.save(p);
    }

    public void deleteByName(String productName) {
        productDAO.deleteProductByName(productName);
    }

    public ProductDto getAllProducts() {
        List<Product> all = productDAO.findAll();
        return ProductDto.builder().products(all).build();
    }

    public int calcMaxProducts(String productName, int budget,int exchange) {
        Product byName = productDAO.findByName(productName);
       return getMaxMilk(budget,byName.getPrice(),exchange);


    }
    public int getMaxMilk(int cash, int price, int epr){
        int maxNumOfBox = 0;
        int numOfBox = cash / price;
        maxNumOfBox = numOfBox;
        int leftOverBox = 0;
        while (numOfBox >= epr) {
            leftOverBox = numOfBox % epr;
            int x = numOfBox / epr;
            maxNumOfBox = maxNumOfBox + x;
            numOfBox = x + leftOverBox;
        }

        return maxNumOfBox;

    }

}
