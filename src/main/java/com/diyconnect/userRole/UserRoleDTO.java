package com.diyconnect.userRole;

import com.diyconnect.role.Role;
import com.diyconnect.user.User;
import jakarta.persistence.*;

public class UserRoleDTO {
    private long userRole_id;
    private User user;
    private Role role;
}
