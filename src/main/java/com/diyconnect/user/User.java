package com.diyconnect.user;

import com.diyconnect.band.Band;
import com.diyconnect.city.City;
import com.diyconnect.message.Message;
import com.diyconnect.userRole.UserRole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    private String username;
    private String email;

    @OneToMany(mappedBy = "sender", fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonBackReference
    private List<Message> messagesSent;

    @OneToMany(mappedBy = "receiver", fetch = FetchType.EAGER)
    @ToString.Exclude
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
    @JsonManagedReference
    private List<UserRole> userRoles;

}
