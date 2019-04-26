package at.mp5er.springrestapi.controller.v1;

import at.mp5er.springrestapi.api.v1.model.CustomerDTO;
import at.mp5er.springrestapi.api.v1.model.CustomerListDTO;
import at.mp5er.springrestapi.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDTO> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(
                new CustomerListDTO(allCustomers), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        CustomerDTO customerDTO =  customerService.getCustomerById(id);
        return new ResponseEntity<>(
                customerDTO, HttpStatus.OK);
    }
}
