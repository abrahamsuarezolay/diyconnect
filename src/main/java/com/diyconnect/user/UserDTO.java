package com.diyconnect.user;

import com.diyconnect.band.Band;
import com.diyconnect.city.City;
import com.diyconnect.message.Message;
import com.diyconnect.userRole.UserRole;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.ToString;

import java.util.List;

public class UserDTO {
    private long user_id;
    private String username;
    private String email;
    private List<Message> messagesSent;
    private List<Message> messagesReceived;
    private City city;
    private List<Band> bands;
    private List<UserRole> userRoles;
}
