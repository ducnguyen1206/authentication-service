package com.sushi.tuyenbeoo.authentication.service.infrastructure.repository;

import com.sushi.tuyenbeoo.authentication.service.domain.entity.RestaurantUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<RestaurantUser, Long> {

    Optional<RestaurantUser> findByLoginId(String loginId);
}
