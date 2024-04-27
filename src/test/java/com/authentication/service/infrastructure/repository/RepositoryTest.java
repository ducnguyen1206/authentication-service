package com.authentication.service.infrastructure.repository;

import com.authentication.service.domain.entity.Module;
import com.authentication.service.domain.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
class RepositoryTest {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void savePermissionRoleRelationshipTest() {
        Module module = new Module();
        module.setName("Module 1");
        module.setStatus("Active");
        module.setCreatedBy("System");
        module.setCreatedDate(LocalDateTime.now());
        module = moduleRepository.save(module);
        assertNotNull(module.getId());

        Permission permission = new Permission();
        permission.setName("Permission 1");
        permission.setStatus("Active");
        permission.setCreatedBy("System");
        permission.setCreatedDate(LocalDateTime.now());
        permission = permissionRepository.save(permission);
        assertNotNull(permission.getId());

        Role role = new Role();
        role.setName("Role 1");
        role.setStatus("Active");
        role.setCreatedBy("System");
        role.setCreatedDate(LocalDateTime.now());
        role = roleRepository.save(role);
        assertNotNull(role.getId());

        RolePermission rolePermission = new RolePermission();
        rolePermission.setRole(role);
        rolePermission.setModule(module);
        rolePermission.setPermission(permission);
        rolePermission.setCreatedBy("System");
        rolePermission.setCreatedDate(LocalDateTime.now());
        rolePermission.setStatus("Active");
        rolePermission = rolePermissionRepository.save(rolePermission);
        assertNotNull(rolePermission.getId());
    }

    @Test
    void saveUserRoleRelationshipTest() {

        Role role = new Role();
        role.setName("Role 1");
        role.setStatus("Active");
        role.setCreatedBy("System");
        role.setCreatedDate(LocalDateTime.now());
        role = roleRepository.save(role);
        assertNotNull(role.getId());

        User user = new User();
        user.setLoginId("userId1");
        user.setName("userId1");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhoneNo("0978331578");
        user.setGender("MALE");
        user.setStatus("Login");
        user.setLogin("IN_PROGRESS");
        user.setStatus("Active");
        user.setCreatedBy("System");
        user.setCreatedDate(LocalDateTime.now());
        user = userRepository.save(user);
        assertNotNull(user.getId());

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRole.setStatus("Active");
        userRole.setCreatedBy("System");
        userRole.setCreatedDate(LocalDateTime.now());
        userRole = userRoleRepository.save(userRole);
        assertNotNull(userRole.getId());
    }
}
