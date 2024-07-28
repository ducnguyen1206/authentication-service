package com.sushi.tuyenbeoo.authentication.service.domain.dto;

import com.sushi.tuyenbeoo.authentication.service.domain.enumf.GenderEnum;
import com.sushi.tuyenbeoo.authentication.service.domain.enumf.RoleEnum;
import com.sushi.tuyenbeoo.authentication.service.domain.enumf.StatusEnum;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String loginId;
    private String name;
    private String password;
    private String email;
    private String phoneNo;
    private GenderEnum gender;
    private StatusEnum status;
    private StatusEnum login;
    private RoleEnum role;
}
