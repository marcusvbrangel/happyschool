package com.marcusvbrangel.happyschool.repository;

import com.marcusvbrangel.happyschool.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findByStatus(String status);

//    Page<Contact> findByStatus(String status, Pageable pageable);

//    @Query("select c from Contact c where c.status = :status")
    @Query(value = "select * from contact_msg where status = :status", nativeQuery = true)
//    Page<Contact> findByStatus(String status, Pageable pageable);
    Page<Contact> findByStatus(@Param("status") String state, Pageable pageable);

    Page<Contact> findOpenMsgs(@Param("status") String status, Pageable pageable);

    @Transactional
    @Modifying
    int updateMsgStatus(String status, int id);

    @Query(nativeQuery = true)
    Page<Contact> findOpenMsgsNative(@Param("status") String status, Pageable pageable);

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    int updateMsgStatusNative(String status, int id);

}
