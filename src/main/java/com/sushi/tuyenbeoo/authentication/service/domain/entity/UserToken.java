package com.sushi.tuyenbeoo.authentication.service.domain.entity;

import com.sushi.tuyenbeoo.authentication.service.domain.constant.DatabaseConstant;
import com.sushi.tuyenbeoo.authentication.service.domain.enumf.TokenType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DatabaseConstant.TOKEN)
public class UserToken extends BaseEntity{

  @Column(unique = true, nullable = false)
  private String token;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private TokenType tokenType = TokenType.BEARER;

  @Column(nullable = false)
  private boolean revoked = Boolean.FALSE;

  @Column(nullable = false)
  private boolean expired = Boolean.FALSE;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}
