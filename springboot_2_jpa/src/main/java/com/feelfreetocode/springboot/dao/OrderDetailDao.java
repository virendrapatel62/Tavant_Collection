package com.feelfreetocode.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.feelfreetocode.springboot.models.Employee;
import com.feelfreetocode.springboot.models.Office;
import com.feelfreetocode.springboot.models.Order;
import com.feelfreetocode.springboot.models.OrderDetail;

public interface OrderDetailDao extends  JpaRepository<OrderDetail, Integer>  {

}
