package de.ait.users.repositories;

import de.ait.users.dto.AddressRequestDTO;
import de.ait.users.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressRepository {
    List<Address> getAdresses();
    Optional<Address> findById(Long id);
    List<Address> findByCountry(String country);
    List<Address> findByCity(String city);
    List<Address> findByStreet(String street);
    List<Address> findByCityAndStreetContaining(String city, String street);
    AddressRepository add(AddressRequestDTO adress);
    Address save(Address address);
    void delete(Long id);
    void update(Long id, AddressRequestDTO addressRequestDTO);




}
