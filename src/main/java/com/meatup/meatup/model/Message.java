package com.meatup.meatup.model;

import lombok.Getter;
import java.util.Map;

@Getter
public class Message {
    private String businessId;
    private String chatroomId;
    private String user;
//    private Content content;
    private Map<String,String> content;
}

@Getter
class Content {
//    private String user;
    private Map<String,String> body;
//    private String date;
}