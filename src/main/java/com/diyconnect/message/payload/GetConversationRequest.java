package com.diyconnect.message.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetConversationRequest {
    private String senderEmail;
    private String receiverEmail;
}
