package com.sushi.tuyenbeoo.authentication.service.domain.entity;

import com.sushi.tuyenbeoo.authentication.service.domain.constant.DatabaseConstant;
import com.sushi.tuyenbeoo.authentication.service.domain.enumf.GenderEnum;
import com.sushi.tuyenbeoo.authentication.service.domain.enumf.RoleEnum;
import com.sushi.tuyenbeoo.authentication.service.domain.enumf.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GenderEnum gender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum login;

    @Column(nullable = false)
    private LocalDateTime lastLogin;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @OneToMany(mappedBy = "user")
    private List<UserToken> tokens;
}
