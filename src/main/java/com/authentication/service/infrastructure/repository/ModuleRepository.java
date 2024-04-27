package com.authentication.service.infrastructure.repository;

import com.authentication.service.domain.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {

}
