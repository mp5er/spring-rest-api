package at.mp5er.springrestapi.api.v1.mapper;


import at.mp5er.springrestapi.api.v1.model.CustomerDTO;
import at.mp5er.springrestapi.domain.Customer;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CustomerMapperTest {

    private static final String FIRSTNAME = "first";
    private static final String LASTNAME = "last";
    private final CustomerMapper sut = CustomerMapper.INSTANCE;

    @Test
    public void shouldMap() {
        // given
        Customer customer = new Customer();
        customer.setFirstname(FIRSTNAME);
        customer.setLastname(LASTNAME);

        // when
        CustomerDTO customerDTO = sut.customerToCustomerDTO(customer);

        // then
        assertThat(customerDTO.getFirstname(), is(FIRSTNAME));
        assertThat(customerDTO.getLastname(), is(LASTNAME));
    }

}