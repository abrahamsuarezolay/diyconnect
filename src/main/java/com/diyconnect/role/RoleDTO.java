package com.diyconnect.role;

import com.diyconnect.userRole.UserRole;
import jakarta.persistence.OneToMany;

import java.util.List;

public class RoleDTO {
    private long role_id;
    private String role_name;
    private List<UserRole> users;
}
