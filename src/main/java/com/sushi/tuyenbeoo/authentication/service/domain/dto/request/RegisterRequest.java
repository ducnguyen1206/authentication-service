package com.sushi.tuyenbeoo.authentication.service.domain.dto.request;

import com.sushi.tuyenbeoo.authentication.service.domain.enumf.GenderEnum;
import com.sushi.tuyenbeoo.authentication.service.domain.enumf.RoleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "LoginId is required")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "dnguyen")
    private String loginId;

    @NotBlank(message = "User name is required")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "David John")
    @Pattern(regexp = "^([^0-9]*)$", message = "Invalid name format")
    private String name;

    @NotBlank(message = "Password is required")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "David John")
    private String password;

    @NotBlank(message = "Email is required")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "john@gmail.com")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "+84901172375")
    @Pattern(regexp = "^(?:\\+\\d{1,2}\\s?)?\\(?\\d{3}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4}$", message = "Invalid phone number format")
    private String phoneNo;

    @NotNull(message = "Gender is required")
    private GenderEnum gender;

    @NotNull
    private RoleEnum role;
}
