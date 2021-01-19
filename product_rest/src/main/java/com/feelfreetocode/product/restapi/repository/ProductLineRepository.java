package com.feelfreetocode.product.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feelfreetocode.product.restapi.models.ProductLine;

public interface ProductLineRepository extends JpaRepository<ProductLine, Integer> {

}
