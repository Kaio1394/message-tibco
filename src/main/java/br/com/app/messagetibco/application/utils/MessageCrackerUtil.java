package br.com.app.messagetibco.application.utils;

import br.com.app.messagetibco.domain.model.MessageTibco;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageCrackerUtil {
    private static final String TAG_SUBJECT = "subject=";
    private static final String TAG_MESSAGE = "message=";
    private static final String REGEX_MESSAGE = "(\\d+)=(\"(?:[^\"]*)\"|\\d+(?:\\.\\d+)?)";

    public MessageTibco parseMessageTibco(String msg){
        MessageTibco msgParsed = new MessageTibco();
        if(msg.isEmpty())
            throw new IllegalArgumentException("Parâmetro 'msg' não pode ser vazio.");
        var listMsg = msg.split(": ");
        if(listMsg.length < 2)
            throw new IllegalArgumentException("Template da mensagem tibco é inválido.");
        String msgWithoutDate = listMsg[1];
        int start = msgWithoutDate.indexOf(TAG_SUBJECT) + TAG_SUBJECT.length();
        int end = msgWithoutDate.indexOf(",", start);
        String subject = msgWithoutDate.trim().substring(start, end);

        msgWithoutDate = msgWithoutDate.replace(TAG_SUBJECT + subject + ", ", "")
                .replace(TAG_MESSAGE, "")
                .replace("{", "")
                .replace("}", "")
                .replace("[", "")
                .replace("]", "");

        Pattern pattern = Pattern.compile(REGEX_MESSAGE);
        Matcher matcher = pattern.matcher(msgWithoutDate);
        Map<Object, Object> map = new HashMap<>();
        while (matcher.find()) {
            int key = Integer.parseInt(matcher.group(1));
            String rawValue = matcher.group(2);
            Object value;
            if (rawValue.startsWith("\"")) {
                value = rawValue.substring(1, rawValue.length() - 1);
            } else if (rawValue.contains(".")) {
                value = Double.parseDouble(rawValue);
            } else {
                value = Integer.parseInt(rawValue);
            }
            map.put(key, value);
        }
        if(map.isEmpty())
            throw new IllegalArgumentException("Template da mensagem tibco é inválido.");
        msgParsed.setSubject(subject);
        msgParsed.setFields(map);
        return msgParsed;
    }
}
