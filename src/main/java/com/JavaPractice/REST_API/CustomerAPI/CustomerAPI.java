package com.JavaPractice.REST_API.CustomerAPI;

import com.JavaPractice.REST_API.CusotmerDTO.CustomerDTO;
import com.JavaPractice.REST_API.DAO_Repository.CustomerRepository;
import com.JavaPractice.REST_API.Exception.InfyBankException;
import com.JavaPractice.REST_API.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/infybank")
public class CustomerAPI {
	
    @Autowired
    private CustomerService customerService;
    @Autowired
    private Environment environment;
    @GetMapping(value = "/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() throws InfyBankException {
        List<CustomerDTO> customerList = customerService.getAllCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
    @GetMapping(value = "/customers/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Integer customerId) throws InfyBankException {
        CustomerDTO customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @PostMapping(value = "/customers")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customer) throws InfyBankException {
         customerService.addCustomer(customer);
       // String successMessage = environment.getProperty("API.INSERT_SUCCESS") + customerId;
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
    @PutMapping(value = "/customers/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDTO customer)
            throws InfyBankException {
        customerService.updateCustomer(customerId, customer.getEmailId());
        String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }
    @DeleteMapping(value = "/customers/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId) throws InfyBankException {
        customerService.deleteCustomer(customerId);
        String successMessage = environment.getProperty("API.DELETE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }
}