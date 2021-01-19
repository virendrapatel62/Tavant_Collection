package com.feelfreetocode.customer.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feelfreetocode.customer.restapi.models.Order;
import com.feelfreetocode.customer.restapi.models.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

}
