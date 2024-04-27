package com.authentication.service.infrastructure.repository;


import com.authentication.service.domain.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
}
