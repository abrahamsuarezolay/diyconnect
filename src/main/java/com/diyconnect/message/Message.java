package com.diyconnect.message;

import com.diyconnect.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

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
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "sender_user_id")
    @JsonBackReference("userMessagesSentReference")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_user_id")
    @JsonBackReference("userMessagesReceivedReference")
    private User receiver;

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", message='" + message + '\'' +
                '}';
    }

    public Message(String message, User sender, User receiver) {
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
    }
}
