package com.meatup.meatup.dto;

import lombok.Getter;

@Getter
public class Location {
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String zip_code;
    private String country;
    private String state;
    private String[] display_address;
    private String cross_streets;

}
