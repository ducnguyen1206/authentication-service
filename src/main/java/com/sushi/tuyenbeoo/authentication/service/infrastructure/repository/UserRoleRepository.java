package com.sushi.tuyenbeoo.authentication.service.infrastructure.repository;

import com.sushi.tuyenbeoo.authentication.service.domain.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query(value = "SELECT * FROM user_role WHERE user_id = ?1", nativeQuery = true)
    Optional<UserRole> findByUserId(Long userId);
}
