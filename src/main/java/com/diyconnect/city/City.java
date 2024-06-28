package com.diyconnect.city;

import com.diyconnect.band.Band;
import com.diyconnect.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long city_id;

    private String name;

    @OneToMany(mappedBy = "city")
    @JsonManagedReference
    private List<User> users;

    @OneToMany(mappedBy = "city")
    @JsonManagedReference
    private List<Band> bands;
}
