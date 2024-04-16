package de.ait.users.services.impl;

import de.ait.users.dto.AddressRequestDTO;
import de.ait.users.model.Address;
import de.ait.users.repositories.AddressRepository;
import de.ait.users.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;

    @Override
    public List<Address> getAdresses() {
        return repository.getAdresses();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Address> findByCountry(String country) {
        return repository.findByCountry(country);
    }

    @Override
    public List<Address> findByCity(String city) {
        return repository.findByCity(city);
    }

    @Override
    public List<Address> findByStreet(String street) {
        return repository.findByStreet(street);
    }

    @Override
    public AddressRepository add(AddressRequestDTO adress) {
        return repository.add(adress);
    }





    @Override
    public List<Address> findByCityAndStreetContaining(String city, String street) {
        return repository.findByCityAndStreetContaining(city, street);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, AddressRequestDTO updatedAddress) {

    }

    @Override
    public Address save(AddressRequestDTO addressRequestDTO) {
        return null;
    }
}
