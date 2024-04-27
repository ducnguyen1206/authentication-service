package com.sushi.tuyenbeoo.authentication.service.infrastructure.repository;


import com.sushi.tuyenbeoo.authentication.service.domain.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
}
