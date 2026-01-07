package br.com.app.messagetibco.application.service;

import br.com.app.messagetibco.domain.model.MessageTibco;
import br.com.app.messagetibco.application.utils.MessageCrackerUtil;

public class MessageCrackerService {
    private final MessageCrackerUtil util;

    public MessageCrackerService(MessageCrackerUtil util){
        this.util = util;
    }

    public MessageTibco parseMessage(String msg){
       return this.util.parseMessageTibco(msg);
    }
}
