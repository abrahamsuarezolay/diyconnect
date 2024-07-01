package com.diyconnect.utils.checkers;

import com.diyconnect.exception.messageException.MessageEmptyException;

public class MessageContentChecker {
    public MessageContentChecker() {

    }

    public boolean isValidMessage(String message){
        if(message.trim().isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
