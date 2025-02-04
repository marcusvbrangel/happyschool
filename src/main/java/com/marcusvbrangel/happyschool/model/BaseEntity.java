package com.marcusvbrangel.happyschool.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(insertable = false)
    private String updatedBy;
}
