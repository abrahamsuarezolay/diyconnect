package com.diyconnect.exception.messageException;

public class MessageEmptyException extends MessageException{

    public MessageEmptyException() {
        super("The message must contain at least one character that is not a blank space.");
    }
}
