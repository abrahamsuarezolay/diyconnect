package com.diyconnect.message;

import com.diyconnect.exception.messageException.MessageEmptyException;
import com.diyconnect.exception.userException.UserNotFoundException;
import com.diyconnect.user.UserService;
import com.diyconnect.utils.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    private EntityMapper entityMapper = new EntityMapper();

    @PostMapping("/sendMessage")
    public ResponseEntity<?> sendMessage(@RequestBody MessageSendRequest messageSendRequest){
        try{
            Message message = new Message(
                    messageSendRequest.getMessage(),
                    userService.findByEmail(messageSendRequest.getSenderEmail()).get(),
                    userService.findByEmail(messageSendRequest.getReceiverEmail()).get()
            );

            messageService.save(message);

            return new ResponseEntity<>(message, HttpStatus.OK);

        }catch(MessageEmptyException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }catch(UserNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
