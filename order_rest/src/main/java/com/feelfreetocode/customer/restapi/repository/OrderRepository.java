package com.feelfreetocode.customer.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feelfreetocode.customer.restapi.models.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
