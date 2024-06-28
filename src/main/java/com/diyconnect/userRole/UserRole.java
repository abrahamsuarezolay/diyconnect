package com.diyconnect.userRole;

import com.diyconnect.role.Role;
import com.diyconnect.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonManagedReference
    private Role role;
}
