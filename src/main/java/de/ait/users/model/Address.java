package de.ait.users.model;

import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@Builder
@Setter

public class Address {
    private  Long id;
    private String country;
    private String zipCode;
    private String city;
    private String street;
    private String house;
}
