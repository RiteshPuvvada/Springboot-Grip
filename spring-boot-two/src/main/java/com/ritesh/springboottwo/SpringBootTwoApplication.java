package com.ritesh.springboottwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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

	static record NewCustomerRequest(
		String name,
		String email,
		Integer age
	){}
	@PostMapping
	public void addCustomer(@RequestBody NewCustomerRequest request){
		Customer customer =  new Customer();
		customer.setName(request.name());
		customer.setEmail(request.email());
		customer.setAge(request.age());
		customerRepository.save(customer);
	}
}
