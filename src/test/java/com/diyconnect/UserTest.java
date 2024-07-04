package com.diyconnect;

import com.diyconnect.user.User;
import com.diyconnect.user.UserService;
import com.diyconnect.userRole.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.AbstractList;
import java.util.ArrayList;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;
}
