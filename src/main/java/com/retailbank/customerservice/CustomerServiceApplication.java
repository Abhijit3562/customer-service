package com.retailbank.customerservice;

import com.retailbank.customerservice.entity.Customer;
import com.retailbank.customerservice.entity.CustomerStatus;
import com.retailbank.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CustomerServiceApplication {

	@Autowired
	CustomerRepository repository;

	public static void main(String[] args) {
		var context = SpringApplication.run(CustomerServiceApplication.class, args);
//
//		CustomerRepository repository = context.getBean(CustomerRepository.class);
//
////		Customer cs = new Customer();
////		cs.setFirstName("Abhi");
////		cs.setLastName("Jadhav");
////		cs.setEmail("abhijeetjadhav2016@gmail.com");
////		cs.setPhone("9146268993");
////		cs.setStatus(CustomerStatus.INITIATED);
////
////		repository.save(cs);
//
////		System.out.println("Customer saved from main()");
//
//		System.out.println("\nDo we have abhi? " + (repository.existsByEmail("abhijeetjadhav2016@gmail.com")?"YES":"NO"));
//
//		Customer customer = repository.findByEmail("abhijeetjadhav2016@gmail.com");
//
//		System.out.println(customer);

	}
}
