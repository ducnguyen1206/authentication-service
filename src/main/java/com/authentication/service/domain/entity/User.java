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
@Table(name = DatabaseConstant.USER)
@SQLDelete(sql = "UPDATE user SET deleted = true WHERE id=?")
@SQLRestriction(value = "deleted=false")
public class User extends BaseEntity {

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNo;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String status;

    private String login;
}
