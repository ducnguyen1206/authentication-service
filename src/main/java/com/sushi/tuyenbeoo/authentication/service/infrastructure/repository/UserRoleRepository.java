package com.sushi.tuyenbeoo.authentication.service.infrastructure.repository;

import com.sushi.tuyenbeoo.authentication.service.domain.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
