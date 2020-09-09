package com.ussd.test.ussdtest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/call/")
public class UssdCaller {

    @PostMapping("starter")
    public String makeFirstCall(USSDdto input){
        System.out.println(input);
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

    @RequestMapping(value = "/ussd", produces = "text/plain", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public String getUssdMessage(USSDdto input) throws Exception {
        System.out.println(input);
       return displayMenu();

    }
}
