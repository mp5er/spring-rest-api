package at.mp5er.springrestapi.service;

import at.mp5er.springrestapi.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);

}
