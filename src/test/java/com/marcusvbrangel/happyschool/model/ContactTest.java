package com.marcusvbrangel.happyschool.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ContactTest {

    @InjectMocks
    private Contact contact;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        contact = new Contact();
    }

    @Test
    void testContactFields() {
        contact.setName("Jane Doe");
        contact.setMobileNum("0987654321");
        contact.setEmail("jane.doe@example.com");
        contact.setSubject("Subject Example");
        contact.setMessage("This is a test message.");
        contact.setStatus("Active");

        assertEquals("Jane Doe", contact.getName());
        assertEquals("0987654321", contact.getMobileNum());
        assertEquals("jane.doe@example.com", contact.getEmail());
        assertEquals("Subject Example", contact.getSubject());
        assertEquals("This is a test message.", contact.getMessage());
        assertEquals("Active", contact.getStatus());
    }

    @Test
    void testContactConstructor() {
        Contact newContact = new Contact();
        assertNotNull(newContact);
    }

    @Test
    void testContactAccessorsAndMutators() {
        contact.setContactId(1);
        assertEquals(1, contact.getContactId());

        contact.setName("Jane Doe");
        assertEquals("Jane Doe", contact.getName());

        contact.setMobileNum("0987654321");
        assertEquals("0987654321", contact.getMobileNum());

        contact.setEmail("jane.doe@example.com");
        assertEquals("jane.doe@example.com", contact.getEmail());

        contact.setSubject("Subject Example");
        assertEquals("Subject Example", contact.getSubject());

        contact.setMessage("This is a test message.");
        assertEquals("This is a test message.", contact.getMessage());

        contact.setStatus("Active");
        assertEquals("Active", contact.getStatus());
    }

}

