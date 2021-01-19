package com.feelfreetocode.customer.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feelfreetocode.customer.restapi.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
