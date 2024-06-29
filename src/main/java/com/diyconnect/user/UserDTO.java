package com.diyconnect.user;

import com.diyconnect.band.Band;
import com.diyconnect.city.City;
import com.diyconnect.message.Message;
import com.diyconnect.userRole.UserRole;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long user_id;
    private String username;
    private String email;
    private List<Message> messagesSent;
    private List<Message> messagesReceived;
    private City city;
    private List<Band> bands;
    private List<UserRole> userRoles;

    public UserDTO(long user_id, String username, String email) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
    }

    public UserDTO(long user_id, String username, String email, City city, List<Band> bands, List<UserRole> userRoles) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.city = city;
        this.bands = bands;
        this.userRoles = userRoles;
    }
}
