package com.diyconnect;

import com.diyconnect.role.Role;
import com.diyconnect.role.RoleService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class RoleTest {

    @Autowired
    private RoleService roleService;


    @Test
    void RoleService_FindByName_Role(){

        Optional<Role> role = roleService.findByName("ROLE_ADMIN");

        Assertions.assertThat(role.isPresent());
        Assertions.assertThat(role.get().getName()).isEqualTo("ROLE_ADMIN");


    }
}
