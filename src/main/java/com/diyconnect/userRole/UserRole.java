package com.diyconnect.userRole;

import com.diyconnect.role.Role;
import com.diyconnect.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "usersRoles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {

    //Intermediate table for many-to-many relation between users and roles

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userRole_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("userUserRolesReference")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonBackReference("roleUserRolesReference")
    private Role role;

    @Override
    public String toString() {
        return "UserRole{" +
                "userRole_id=" + userRole_id +
                "role=" + role.getName() +
                '}';
    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }
}
