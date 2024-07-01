package com.diyconnect;

import com.diyconnect.message.Message;
import com.diyconnect.message.MessageService;
import com.diyconnect.user.User;
import com.diyconnect.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MessageTest {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @Test
    public void MessageService_SaveNewMessage_ReturnsMessage(){

        User user1 = userService.findById(1L).get();
        User user2 = userService.findById(2L).get();

        //Message message = messageService.save(new Message("Hola que tal", user1, user2));

        System.out.println(user1.getMessagesSent());
        System.out.println(user2.getMessagesReceived());

    }

}
