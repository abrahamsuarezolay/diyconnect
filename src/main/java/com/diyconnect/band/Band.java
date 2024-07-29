package com.diyconnect.band;

import com.diyconnect.city.City;
import com.diyconnect.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bands")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long band_id;

    private String name;
    private String gender;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("userBandsReference")
    private User user;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference("cityBandsReference")
    private City city;

    private List<String> links;

    @Override
    public String toString() {
        return "Band{" +
                "band_id=" + band_id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                ", links=" + links +
                '}';
    }
}
