package com.ussd.test.ussdtest.controller;

import lombok.Data;

@Data
public class USSDdto {
    private String sessionId;
    private String phoneNumber;
    private String networkCode;
    private String serviceCode;
    private String text;
}
