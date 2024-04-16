package de.ait.users.services;

import de.ait.users.dto.AddressRequestDTO;
import de.ait.users.model.Address;
import de.ait.users.repositories.AddressRepository;

import java.util.List;
import java.util.Optional;

public  interface AddressService {
    List<Address> getAdresses();

    Optional<Address> findById(Long id);

    List<Address> findByCountry(String country);

    List<Address> findByCity(String city);

    List<Address> findByStreet(String street);

    AddressRepository add(AddressRequestDTO adress);

    void delete(Long id);

    void update(Long id, AddressRequestDTO updatedAddress);

    Address save(AddressRequestDTO addressRequestDTO);


    List<Address> findByCityAndStreetContaining(String city, String street);
}

