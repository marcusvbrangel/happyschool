package com.marcusvbrangel.happyschool.repository;

import com.marcusvbrangel.happyschool.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
