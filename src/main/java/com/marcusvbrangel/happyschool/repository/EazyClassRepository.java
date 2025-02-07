package com.marcusvbrangel.happyschool.repository;

import com.marcusvbrangel.happyschool.model.EazyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EazyClassRepository extends JpaRepository<EazyClass, Integer> {

}
