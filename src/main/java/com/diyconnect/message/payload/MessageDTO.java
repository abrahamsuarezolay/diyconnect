package com.diyconnect.message.payload;
import com.diyconnect.user.User;
import com.diyconnect.user.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

    private long message_id;
    private String message;
    private User sender;
    private User receiver;

    public MessageDTO(String message, User sender, User receiver) {
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
    }
}
