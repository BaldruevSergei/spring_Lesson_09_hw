package de.ait.users.repositories.impl;
import javax.persistence.EntityNotFoundException;
import de.ait.users.dto.AddressRequestDTO;
import de.ait.users.model.Address;
import de.ait.users.repositories.AddressRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    private List<Address> addressList = new ArrayList<>(List.of(
            new Address(1L, "USA", "12030", "NEW-YORK", "Manhattan", "4"),
            new Address(2L, "France", "75000", "PARIS", "Paris Centre", "15"),
            new Address(3L, "UK", "W1B 2EL", "LONDON", "Westminster", "7"),
            new Address(4L, "Germany", "10115", "BERLIN", "Mitte", "12"),
            new Address(5L, "Japan", "100-8111", "TOKYO", "Chiyoda", "1"),
            new Address(6L, "Russia", "101000", "MOSCOW", "Central", "20"),
            new Address(7L, "Canada", "M5H 2N2", "TORONTO", "Old Toronto", "33"),
            new Address(8L, "Australia", "2000", "SYDNEY", "Sydney CBD", "5"),
            new Address(9L, "India", "110001", "NEW DELHI", "Connaught Place", "19"),
            new Address(10L, "Brazil", "01000-000", "SAO PAULO", "Central", "42"),
            new Address(11L, "South Africa", "8001", "CAPE TOWN", "City Bowl", "8"),
            new Address(12L, "South Korea", "03000", "SEOUL", "Jongno-gu", "2"),
            new Address(13L, "China", "100000", "BEIJING", "Dongcheng", "11"),
            new Address(14L, "Mexico", "06000", "MEXICO CITY", "Cuauhtémoc", "22"),
            new Address(15L, "Italy", "00100", "ROME", "Municipio I", "10"),
            new Address(16L, "Spain", "28001", "MADRID", "Salamanca", "30"),
            new Address(17L, "Netherlands", "1000", "AMSTERDAM", "Centrum", "4"),
            new Address(18L, "UAE", "00000", "DUBAI", "Bur Dubai", "9"),
            new Address(19L, "Argentina", "C1001", "BUENOS AIRES", "San Nicolás", "3"),
            new Address(20L, "Turkey", "34000", "ISTANBUL", "Fatih", "14"),
            new Address(21L, "Egypt", "11511", "CAIRO", "Al Qahirah", "18"),
            new Address(22L, "France", "33000", "BORDEAUX", "Centre Ville", "27"),
            new Address(23L, "UK", "EH1 1YZ", "EDINBURGH", "Old Town", "3"),
            new Address(24L, "Germany", "20095", "HAMBURG", "Hamburg-Mitte", "18"),
            new Address(25L, "Japan", "530-0001", "OSAKA", "Kita", "12"),
            new Address(26L, "Russia", "190000", "SAINT PETERSBURG", "Tsentralny District", "5"),
            new Address(27L, "Canada", "H3B 2E3", "MONTREAL", "Ville-Marie", "9"),
            new Address(28L, "Australia", "3000", "MELBOURNE", "Melbourne CBD", "21"),
            new Address(29L, "India", "400001", "MUMBAI", "Fort", "10"),
            new Address(30L, "Brazil", "20031-110", "RIO DE JANEIRO", "Centro", "33"),
            new Address(31L, "South Africa", "0028", "PRETORIA", "Pretoria Central", "15"),
            new Address(32L, "South Korea", "100-250", "BUSAN", "Jung District", "6"),
            new Address(33L, "China", "200000", "SHANGHAI", "Huangpu District", "19"),
            new Address(34L, "Mexico", "44100", "GUADALAJARA", "Centro", "20"),
            new Address(35L, "Italy", "50123", "FLORENCE", "Historical Center", "7"),
            new Address(36L, "Spain", "08001", "BARCELONA", "Ciutat Vella", "8"),
            new Address(37L, "Netherlands", "2511 BT", "THE HAGUE", "Centrum", "2"),
            new Address(38L, "UAE", "00000", "ABU DHABI", "Al Danah", "11"),
            new Address(39L, "Argentina", "5000", "CORDOBA", "Centro", "16"),
            new Address(40L, "Turkey", "06050", "ANKARA", "Çankaya", "28"),
            new Address(41L, "Egypt", "21111", "ALEXANDRIA", "Al Mansheya", "14"),
            new Address(42L, "USA", "12030", "NEW-YORK", "Manhattan", "5"),
            new Address(43L, "USA", "12030", "NEW-YORK", "Manhattan", "6"),
            new Address(44L, "France", "75000", "PARIS", "Paris Centre", "16"),
            new Address(45L, "France", "75000", "PARIS", "Paris Centre", "17"),
            new Address(46L, "UK", "W1B 2EL", "LONDON", "Westminster", "8"),
            new Address(47L, "UK", "W1B 2EL", "LONDON", "Westminster", "9"),
            new Address(48L, "Germany", "10115", "BERLIN", "Mitte", "13"),
            new Address(49L, "Germany", "10115", "BERLIN", "Mitte", "14"),
            new Address(50L, "Japan", "100-8111", "TOKYO", "Chiyoda", "2"),
            new Address(51L, "Japan", "100-8111", "TOKYO", "Chiyoda", "3"),
            new Address(52L, "Russia", "101000", "MOSCOW", "Central", "21"),
            new Address(53L, "Russia", "101000", "MOSCOW", "Central", "22"),
            new Address(54L, "Canada", "M5H 2N2", "TORONTO", "Old Toronto", "34"),
            new Address(55L, "Canada", "M5H 2N2", "TORONTO", "Old Toronto", "35"),
            new Address(56L, "Australia", "2000", "SYDNEY", "Sydney CBD", "6"),
            new Address(57L, "Australia", "2000", "SYDNEY", "Sydney CBD", "7"),
            new Address(58L, "India", "110001", "NEW DELHI", "Connaught Place", "20"),
            new Address(59L, "India", "110001", "NEW DELHI", "Connaught Place", "21"),
            new Address(60L, "Brazil", "01000-000", "SAO PAULO", "Central", "43"),
            new Address(61L, "Brazil", "01000-000", "SAO PAULO", "Central", "44"),
            new Address(62L, "South Africa", "8001", "CAPE TOWN", "City Bowl", "9"),
            new Address(63L, "South Africa", "8001", "CAPE TOWN", "City Bowl", "10"),
            new Address(64L, "South Korea", "03000", "SEOUL", "Jongno-gu", "3"),
            new Address(65L, "South Korea", "03000", "SEOUL", "Jongno-gu", "4"),
            new Address(66L, "China", "100000", "BEIJING", "Dongcheng", "12"),
            new Address(67L, "China", "100000", "BEIJING", "Dongcheng", "13"),
            new Address(68L, "Mexico", "06000", "MEXICO CITY", "Cuauhtémoc", "23"),
            new Address(69L, "Mexico", "06000", "MEXICO CITY", "Cuauhtémoc", "24"),
            new Address(70L, "Italy", "00100", "ROME", "Municipio I", "11"),
            new Address(71L, "Italy", "00100", "ROME", "Municipio I", "12"),
            new Address(72L, "Spain", "28001", "MADRID", "Salamanca", "31"),
            new Address(73L, "Spain", "28001", "MADRID", "Salamanca", "32"),
            new Address(74L, "Netherlands", "1000", "AMSTERDAM", "Centrum", "5"),
            new Address(75L, "Netherlands", "1000", "AMSTERDAM", "Centrum", "6"),
            new Address(76L, "UAE", "00000", "DUBAI", "Bur Dubai", "10"),
            new Address(77L, "UAE", "00000", "DUBAI", "Bur Dubai", "11"),
            new Address(78L, "Argentina", "C1001", "BUENOS AIRES", "San Nicolás", "4"),
            new Address(79L, "Argentina", "C1001", "BUENOS AIRES", "San Nicolás", "5"),
            new Address(80L, "Turkey", "34000", "ISTANBUL", "Fatih", "15"),
            new Address(81L, "Turkey", "34000", "ISTANBUL", "Fatih", "16"),
            new Address(82L, "Egypt", "11511", "CAIRO", "Al Qahirah", "19"),
            new Address(83L, "Egypt", "11511", "CAIRO", "Al Qahirah", "20")
    ));

    @Override
    public List<Address> getAdresses() {
        return addressList;
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressList.stream()
                .filter(a->a.getId().equals(id))
                .findAny();
    }

    @Override
    public List<Address> findByCountry(String country) {
        return addressList.stream()
                .filter(a -> a.getCountry().equalsIgnoreCase(country))
                .collect(Collectors.toList());
    }


    @Override
    public List<Address> findByCity(String city) {
        return addressList.stream()
                .filter(a->a.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    @Override
    public List<Address> findByStreet(String street) {
        return addressList.stream()
                .filter(s->s.getStreet().equalsIgnoreCase(street))
                .collect(Collectors.toList());
    }

    @Override
    public List<Address> findByCityAndStreetContaining(String city, String street) {
        System.out.println("Searching for addresses in city: " + city + " and street containing: " + street);
        return addressList.stream()
                .filter(address -> (address.getCity().equalsIgnoreCase(city)) &&
                        (address.getStreet().toLowerCase().contains(street.toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public AddressRepository add(AddressRequestDTO adress) {
        return null;
    }


    @Override
    public Address save(Address address) {
        addressList.add(address);
        return address;
    }



    @Override
    public void delete(Long id) {
        addressList.removeIf(i->i.getId().equals(id));

    }
    @Override
    public void update(Long id, AddressRequestDTO addressRequestDTO) {
        Optional<Address> optionalAddress = findById(id);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();

            // Обновить данные адреса
            address.setCountry(addressRequestDTO.getCountry());
            address.setZipCode(addressRequestDTO.getZipCode());
            address.setCity(addressRequestDTO.getCity());
            address.setStreet(addressRequestDTO.getStreet());
            address.setHouse(addressRequestDTO.getHouse());

            // Сохранить обновленный адрес
            save(address);
        } else {
            // Обработать ситуацию, если адрес с указанным ID не найден
            throw new EntityNotFoundException("Адрес с id: " + id + " не найден.");
        }
    }


}

