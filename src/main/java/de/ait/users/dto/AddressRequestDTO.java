package de.ait.users.dto;

import de.ait.users.model.Address;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@ToString
@Builder
@Setter
public class AddressRequestDTO {


        private String country;
        private String zipCode;
        private String city;
        private String street;
        private String house;
       public static AddressRequestDTO form(Address address){
        return AddressRequestDTO.builder()
                .country(address.getCountry())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .street(address.getCity())
                .house(address.getHouse())
                .build();
    }

    public  static List<AddressRequestDTO> form(List<Address> addresses){
           return addresses.stream().map(AddressRequestDTO::form).collect(Collectors.toList());
    }

}
