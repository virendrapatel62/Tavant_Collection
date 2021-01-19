package com.feelfreetocode.product.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feelfreetocode.product.restapi.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
