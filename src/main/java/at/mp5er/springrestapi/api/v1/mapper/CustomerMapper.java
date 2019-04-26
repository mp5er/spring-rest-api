package at.mp5er.springrestapi.api.v1.mapper;

import at.mp5er.springrestapi.api.v1.model.CustomerDTO;
import at.mp5er.springrestapi.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );

    CustomerDTO customerToCustomerDTO(Customer customer);
}
