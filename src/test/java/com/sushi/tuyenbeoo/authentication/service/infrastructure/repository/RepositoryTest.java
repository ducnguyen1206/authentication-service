package com.sushi.tuyenbeoo.authentication.service.infrastructure.repository;

import com.sushi.tuyenbeoo.authentication.service.domain.entity.*;
import com.sushi.tuyenbeoo.authentication.service.domain.entity.Module;
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

        RestaurantUser restaurantUser = new RestaurantUser();
        restaurantUser.setLoginId("userId1");
        restaurantUser.setName("userId1");
        restaurantUser.setPassword("password");
        restaurantUser.setEmail("email");
        restaurantUser.setPhoneNo("0978331578");
        restaurantUser.setGender("MALE");
        restaurantUser.setStatus("Login");
        restaurantUser.setLogin("IN_PROGRESS");
        restaurantUser.setStatus("Active");
        restaurantUser.setCreatedBy("System");
        restaurantUser.setCreatedDate(LocalDateTime.now());
        restaurantUser = userRepository.save(restaurantUser);
        assertNotNull(restaurantUser.getId());

        UserRole userRole = new UserRole();
        userRole.setUserId(restaurantUser);
        userRole.setRoleId(role);
        userRole.setStatus("Active");
        userRole.setCreatedBy("System");
        userRole.setCreatedDate(LocalDateTime.now());
        userRole = userRoleRepository.save(userRole);
        assertNotNull(userRole.getId());
    }
}
