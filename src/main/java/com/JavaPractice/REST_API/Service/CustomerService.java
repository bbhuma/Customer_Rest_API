package com.JavaPractice.REST_API.Service;

import com.JavaPractice.REST_API.CusotmerDTO.CustomerDTO;
import com.JavaPractice.REST_API.Exception.InfyBankException;

import java.util.List;

public interface CustomerService {
    public CustomerDTO getCustomer(Integer customerId) throws InfyBankException;
    public List<CustomerDTO> getAllCustomers() throws InfyBankException;
    public CustomerDTO addCustomer(CustomerDTO customer) throws InfyBankException;
    public void updateCustomer(Integer customerId, String emailId) throws InfyBankException;
    public void deleteCustomer(Integer customerId) throws InfyBankException;
}