package de.ait.users.repositories.impl;

import de.ait.users.dto.AddressRequestDTO;
import de.ait.users.model.Address;
import de.ait.users.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AddressRepositoryJDBCTemplateImpl implements AddressRepository {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public static final String ID = "id";
    public static final String COUNTRY = "country";
    public static final String ZIPCODE = "zipcode";
    public static final String CITY = "city";
    public static final String STREET = "street";
    public static final String HOUSET_NAME = "houset_name";

    private static final RowMapper<Address> ADDRESS_ROW_MAPPER = (row, rowNun) ->
    {
        long id = row.getLong(ID);
        String country = row.getString(COUNTRY);
        String zipcode = row.getString(ZIPCODE);
        String city = row.getString(CITY);
        String street = row.getString(STREET);
        String housetName = row.getString(HOUSET_NAME);
        return new Address(id, country, zipcode, city, street, housetName);
    };



    @Override
    public List<Address> getAdresses() {
        return jdbcTemplate.query("SELECT * FROM address", ADDRESS_ROW_MAPPER);
    }

    @Override
    public Optional<Address> findById(Long id) {
        Address address = jdbcTemplate.queryForObject("SELECT * FROM address WHERE id = ?", ADDRESS_ROW_MAPPER, id);
        return Optional.ofNullable(address);
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
