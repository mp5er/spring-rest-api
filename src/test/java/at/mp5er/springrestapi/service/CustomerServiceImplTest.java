package at.mp5er.springrestapi.service;

import at.mp5er.springrestapi.api.v1.mapper.CustomerMapper;
import at.mp5er.springrestapi.api.v1.model.CustomerDTO;
import at.mp5er.springrestapi.domain.Customer;
import at.mp5er.springrestapi.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerService sut;

    @Before
    public void setUp() {
            sut = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }

    @Test
    public void getAllCustomers() {
        // given
        Customer c1 = new Customer();
        c1.setFirstname("sam");
        c1.setLastname("axe");
        c1.setId(1L);

        Customer c2 = new Customer();
        c1.setFirstname("john");
        c1.setLastname("snow");
        c1.setId(2L);

        when(customerRepository.findAll()).thenReturn(Arrays.asList(c1, c2));

        // when
        List<CustomerDTO> customers = sut.getAllCustomers();

        // then
        assertThat(customers.size(), is(2));
    }

    @Test
    public void getById() {
        // given
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setLastname("last");
        customer.setFirstname("first");
        when(customerRepository.findById(eq(1L))).thenReturn(Optional.of(customer));

        // when
        CustomerDTO dto = sut.getCustomerById(1L);

        // then
        assertThat(dto.getLastname(), is("last"));
        assertThat(dto.getFirstname(), is("first"));
    }
}