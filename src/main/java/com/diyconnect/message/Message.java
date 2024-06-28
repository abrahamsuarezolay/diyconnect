package com.diyconnect.message;

import com.diyconnect.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long message_id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "sender_user_id")
    @ToString.Exclude
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_user_id")
    @ToString.Exclude
    private User receiver;
}
