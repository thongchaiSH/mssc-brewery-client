package com.ith.msscbreweryclient.web.client;

import com.ith.msscbreweryclient.web.model.BeerDto;
import com.ith.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto=client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {
        BeerDto beerDto=BeerDto.builder().beerName("New Beer").build();

        URI uri=client.saveNewBeer(beerDto);

        assertNotNull(uri.toString());
    }

    @Test
    void testUpdateBeer() {
        BeerDto beerDto=BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(),beerDto);
    }


    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto dto=client.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto customerDto=CustomerDto.builder().name("Thongchai").build();

        URI uri=client.saveNewCustomer(customerDto);

        assertNotNull(uri.toString());
    }

    @Test
    void updateCustomer() {
        CustomerDto customerDto=CustomerDto.builder().name("Thongchai").build();

        client.updateCustomer(UUID.randomUUID(),customerDto);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}