package com.ritesh.springboottwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customer")
public class SpringBootTwoApplication {
	private final CustomerRepository customerRepository;
	public SpringBootTwoApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTwoApplication.class, args);
	}
	@GetMapping
	public List<Customer> getCustomer(){
		return customerRepository.findAll();
	}
}
