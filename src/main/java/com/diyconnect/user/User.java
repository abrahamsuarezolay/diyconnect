package com.diyconnect.user;

import com.diyconnect.band.Band;
import com.diyconnect.city.City;
import com.diyconnect.message.Message;
import com.diyconnect.userRole.UserRole;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(unique = true)
    private String username;
    private String email;
    private boolean enabled = true;

    @OneToMany(mappedBy = "sender", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Message> messagesSent;

    @OneToMany(mappedBy = "receiver", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Message> messagesReceived;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference
    private City city;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Band> bands;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<UserRole> userRoles;

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
