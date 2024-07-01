package com.diyconnect.utils.mappers;

import com.diyconnect.message.Message;
import com.diyconnect.message.payload.MessageDTO;

public class EntityMapper {
    public EntityMapper() {
    }

    public Message messageDTOtoMessage(MessageDTO messageDTO) {
        Message message = new Message(
                messageDTO.getMessage(),
                messageDTO.getSender(),
                messageDTO.getReceiver()
        );
        return message;
    }

}
