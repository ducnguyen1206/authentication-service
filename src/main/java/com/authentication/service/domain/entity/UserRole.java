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
@Table(name = DatabaseConstant.USER_ROLE)
@SQLDelete(sql = "UPDATE user_role SET deleted = true WHERE id=?")
@SQLRestriction(value = "deleted=false")
public class UserRole extends BaseEntity {

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;
}
