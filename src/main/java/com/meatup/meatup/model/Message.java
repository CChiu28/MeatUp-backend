package com.meatup.meatup.model;

import lombok.Getter;
import java.util.Map;

@Getter
public class Message {
    private String businessId;
    private String chatroomId;
    //    private String user;
    private Content content;
//    private Map<String,String> content;
}