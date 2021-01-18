package com.feelfreetocode.restapi.controllers;

import java.rmi.NoSuchObjectException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feelfreetocode.restapi.exceptions.EmployeeNotFoundException;
import com.feelfreetocode.restapi.models.Customer;
import com.feelfreetocode.restapi.models.Employee;
import com.feelfreetocode.restapi.models.Payment;
import com.feelfreetocode.restapi.models.PaymentId;
import com.feelfreetocode.restapi.models.Product;
import com.feelfreetocode.restapi.repository.PaymentRepository;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	
	@Autowired
	private PaymentRepository paymentRepository;


	@PostMapping()
	public Payment createPayment(@RequestBody @Valid Payment payment) {
		return this.paymentRepository.save(payment);
	}
	
	@GetMapping()
	public List<Payment> getPayments() {
		return this.paymentRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity getPaymentById(@PathVariable("id") Integer id) throws Exception {
		try {
			PaymentId paymentId = new PaymentId();
			Customer customer = new Customer();
			customer.setCustomerNumber(id);
			paymentId.setCustomer(customer);
			return ResponseEntity.ok(this.paymentRepository.findById(paymentId).get());
		} catch (Exception e) {
			throw new NoSuchObjectException("Payment Not Found With Given Id");
		}
	}


}
