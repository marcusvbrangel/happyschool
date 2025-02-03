package com.marcusvbrangel.happyschool.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonTest {

    @InjectMocks
    private Person person;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        person = new Person();
    }

    @Test
    void testPersonFields() {
        person.setName("John Doe");
        person.setMobileNumber("1234567890");
        person.setEmail("john.doe@example.com");
        person.setConfirmEmail("john.doe@example.com");
        person.setPwd("password123");
        person.setConfirmPwd("password123");

        assertEquals("John Doe", person.getName());
        assertEquals("1234567890", person.getMobileNumber());
        assertEquals("john.doe@example.com", person.getEmail());
        assertEquals("john.doe@example.com", person.getConfirmEmail());
        assertEquals("password123", person.getPwd());
        assertEquals("password123", person.getConfirmPwd());
    }

    @Test
    void testPersonRoles() {
        Roles roles = new Roles();
        roles.setRoleId(1);
        roles.setRoleName("USER");

        person.setRoles(roles);

        assertNotNull(person.getRoles());
        assertEquals(1, person.getRoles().getRoleId());
        assertEquals("USER", person.getRoles().getRoleName());
    }

    @Test
    void testPersonAddress() {
        Address address = new Address();
        address.setAddressId(1);
        address.setCity("Anytown");
        address.setState("Anystate");
        address.setZipCode(12345);

        person.setAddress(address);

        assertNotNull(person.getAddress());
        assertEquals(1, person.getAddress().getAddressId());
        assertEquals("Anytown", person.getAddress().getCity());
        assertEquals("Anystate", person.getAddress().getState());
        assertEquals(12345, person.getAddress().getZipCode());
    }

}