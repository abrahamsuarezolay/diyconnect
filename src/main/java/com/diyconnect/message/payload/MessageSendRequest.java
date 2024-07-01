package com.diyconnect.message.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageSendRequest {

    private String message;
    private String senderEmail;
    private String receiverEmail;

}
