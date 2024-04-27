package com.authentication.service.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreatedBy
    @Column(updatable = false, nullable = false)
    protected String createdBy;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    protected LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "last_updated_date")
    protected LocalDateTime lastModifiedDate;

    @LastModifiedBy
    @Column(name = "last_updated_by")
    protected String lastModifiedBy;

    private boolean deleted = Boolean.FALSE;
}
