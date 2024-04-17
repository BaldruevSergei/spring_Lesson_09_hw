package de.ait.users.controllers;

import de.ait.users.dto.AddressRequestDTO;
import de.ait.users.model.Address;
import de.ait.users.repositories.AddressRepository;
import de.ait.users.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AddressController {
    private final AddressService service;

    @GetMapping("/address")
    List<Address> getAdresses() {
        return service.getAdresses();
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id) {
        Optional<Address> optionalAddress = service.findById(id);
        if (optionalAddress.isPresent()) {
            return ResponseEntity.ok(optionalAddress.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/address/country/{country}")
    public List<Address> findByCountry(@PathVariable String country) {
        List<Address> addresses = service.findByCountry(country);
        if (addresses.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No addresses found for country: " + country);
        }
        return addresses;
    }

    @GetMapping("/address/city/{city}")
    public List<Address> findByCity(@PathVariable String city) {
        List<Address> addresses = service.findByCity(city);
        if (addresses.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No addresses found for country: " + city);
        }
        return addresses;
    }

    @GetMapping("/address/street/{street}")
    public List<Address> findByStreet(@PathVariable String street) {
        List<Address> addresses = service.findByStreet(street);
        if (addresses.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No addresses found for street: " + street);
        }
        return addresses;
    }

    @GetMapping("/addresses/search")
    public List<Address> findByCityAndStreetContaining(
            @RequestParam("city") String city,
            @RequestParam("street") String street
    ) {
        return service.findByCityAndStreetContaining(city, street);
    }

    @PostMapping("/address/add")
    public ResponseEntity<AddressRequestDTO> addNewAddress(@RequestBody AddressRequestDTO addressRequestDTO) {
        // Проверка на валидность addressRequestDTO при необходимости

        // Создание нового объекта Address из DTO
        Address newAddress = Address.builder()
                .country(addressRequestDTO.getCountry())
                .zipCode(addressRequestDTO.getZipCode())
                .city(addressRequestDTO.getCity())
                .street(addressRequestDTO.getStreet())
                .house(addressRequestDTO.getHouse())
                .build();

        // Добавление нового адреса
        service.add(AddressRequestDTO.form(newAddress));

        // Возврат ответа, указывающего на успешность операции
        return ResponseEntity.status(HttpStatus.CREATED).body(addressRequestDTO);
    }


    @DeleteMapping("/address/{id}")
    public void delete(@PathVariable Long id) {

        service.delete(id);
        System.out.println("Delete access");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAddress(@PathVariable Long id, @RequestBody AddressRequestDTO addressRequestDTO) {
        try {
            service.update(id, addressRequestDTO);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

