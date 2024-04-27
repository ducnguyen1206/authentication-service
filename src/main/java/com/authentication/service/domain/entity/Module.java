package com.authentication.service.domain.entity;

import com.authentication.service.domain.constant.DatabaseConstant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DatabaseConstant.MODULE)
@SQLDelete(sql = "UPDATE module SET deleted = true WHERE id=?")
@SQLRestriction(value = "deleted=false")
public class Module extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String status;
}
