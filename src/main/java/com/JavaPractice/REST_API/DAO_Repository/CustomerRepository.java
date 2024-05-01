package com.JavaPractice.REST_API.DAO_Repository;

import com.JavaPractice.REST_API.Entity_Model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}