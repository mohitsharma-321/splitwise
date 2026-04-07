package com.company.splitwise.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@MappedSuperclass // to create an entity super class
@EntityListeners(AuditingEntityListener.class) // to create audit fileds like createdAt etc..
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // to auto generate this field
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;


}
