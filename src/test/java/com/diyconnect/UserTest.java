package com.diyconnect;

import com.diyconnect.user.User;
import com.diyconnect.user.UserService;
import com.diyconnect.userRole.UserRole;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.AbstractList;
import java.util.ArrayList;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    void UserService_AddNewUser_ReturnsUser() {
        User user = new User("deadbolt", "deadbolt@gmail.com", "1234");

        userService.save(user);

        Assertions.assertThat(userService.findByEmail("deadbolt@gmail.com").isPresent());
    }
}
