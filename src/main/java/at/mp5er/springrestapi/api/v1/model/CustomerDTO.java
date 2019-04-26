package at.mp5er.springrestapi.api.v1.model;

import lombok.Data;

@Data
public class CustomerDTO {

    private String customerUrl;
    private String firstname;
    private String lastname;
}
