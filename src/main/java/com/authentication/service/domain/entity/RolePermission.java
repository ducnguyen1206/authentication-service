package com.authentication.service.domain.entity;

import com.authentication.service.domain.constant.DatabaseConstant;
import jakarta.persistence.*;
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
@Table(name = DatabaseConstant.ROLE_PERMISSION)
@SQLDelete(sql = "UPDATE role_permission SET deleted = true WHERE id=?")
@SQLRestriction(value = "deleted=false")
public class RolePermission extends BaseEntity {

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;

    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission;
}
