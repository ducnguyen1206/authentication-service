package com.sushi.tuyenbeoo.authentication.service.domain.entity;

import com.sushi.tuyenbeoo.authentication.service.domain.constant.DatabaseConstant;
import com.sushi.tuyenbeoo.authentication.service.domain.enumf.StatusEnum;
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
@Table(name = DatabaseConstant.USER)
@SQLDelete(sql = "UPDATE user SET deleted = true WHERE id=?")
@SQLRestriction(value = "deleted=false")
public class RestaurantUser extends BaseEntity {

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum login;
}
