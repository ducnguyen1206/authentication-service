package com.authentication.service.infrastructure.repository;

import com.authentication.service.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
