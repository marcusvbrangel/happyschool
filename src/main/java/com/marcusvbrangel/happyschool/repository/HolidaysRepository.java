package com.marcusvbrangel.happyschool.repository;

import com.marcusvbrangel.happyschool.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday, String> {

}
