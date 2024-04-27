package com.sushi.tuyenbeoo.authentication.service.domain.entity;

import com.sushi.tuyenbeoo.authentication.service.domain.constant.DatabaseConstant;
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
@Table(name = DatabaseConstant.ROLE)
@SQLDelete(sql = "UPDATE role SET deleted = true WHERE id=?")
@SQLRestriction(value = "deleted=false")
public class Role extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String status;
}
