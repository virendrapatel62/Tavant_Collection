package com.feelfreetocode.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feelfreetocode.restapi.models.Customer;
import com.feelfreetocode.restapi.models.Payment;
import com.feelfreetocode.restapi.models.PaymentId;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, PaymentId> {

}
