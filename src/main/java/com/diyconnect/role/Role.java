package com.diyconnect.role;

import com.diyconnect.user.User;
import com.diyconnect.userRole.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long role_id;
    private String role_name;

    @OneToMany(mappedBy = "role")
    private List<UserRole> users;

}
