package de.ait.users.repositories.impl;

import de.ait.users.dto.AddressRequestDTO;
import de.ait.users.model.Address;
import de.ait.users.repositories.AddressRepository;

import java.util.List;
import java.util.Optional;

public class AddressRepositoryJDBCimpl implements AddressRepository {
    @Override
    public List<Address> getAdresses() {
        return List.of();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Address> findByCountry(String country) {
        return List.of();
    }

    @Override
    public List<Address> findByCity(String city) {
        return List.of();
    }

    @Override
    public List<Address> findByStreet(String street) {
        return List.of();
    }

    @Override
    public List<Address> findByCityAndStreetContaining(String city, String street) {
        return List.of();
    }

    @Override
    public AddressRepository add(AddressRequestDTO adress) {
        return null;
    }

    @Override
    public Address save(Address address) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, AddressRequestDTO addressRequestDTO) {

    }
}
