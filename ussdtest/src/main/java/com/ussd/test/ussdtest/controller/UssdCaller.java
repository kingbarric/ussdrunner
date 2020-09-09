package com.ussd.test.ussdtest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/call/")
public class UssdCaller {

    @PostMapping("starter")
    public String makeFirstCall(){
        return displayMenu();
    }
    private String displayMenu() {
        String response = "";
        response = "CON What would you want to check \n";
        response += "1. Check Balance \n";
        response += "2. Transfer \n";
        response += "3. Airtime \n";
        response += "4. Name enquiry \n";
        response += "5. Sell Crop";
        return response;
    }
}
