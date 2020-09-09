package com.ussd.test.ussdtest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/call/")

public class UssdCaller {

//    @PostMapping("starter")
//    @ResponseBody
//    public String makeFirstCall(USSDdto input){
//        System.out.println(input);
//        if(input.getText() ==null){
//            return  displayMenu();
//        }
//        int choice  = Integer.parseInt(input.getText());
//        switch (choice){
//            case 1:
//
//        }
//    }
    private String displayMenu() {
        String response = "";
        response = "CON What would you want to check \n";
        response += "1. Check Balance \n";
        response += "2. Transfer \n";
        response += "4. End \n";
        return response;
    }

    @RequestMapping(value = "/starter", produces = "text/plain", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public String getUssdMessage(USSDdto input) throws Exception {
        System.out.println(input);
        //String[] array = input.getText().split("\\*", -1);
        String text = input.getText().trim();
        String[] array = text.split("\\*", -1);
        int level = array.length;
        if (StringUtils.isEmpty(input.getText())) {
            return displayMenu(); // show the home/first menu
        }
        else if (level > 0) {
            if ("1".equalsIgnoreCase(array[0])) {

                return ussd_end("your balance is #5000m");
            } else if ("2".equalsIgnoreCase(array[0])) {
                // If user selected 2, send them to the about menu
                return ussd_end("you have transferred  #5000m");
            } else if ("3".equalsIgnoreCase(array[0])) {
                // If user selected 2, send them to the about menu
                return ussd_proceed("try a different choice");
            }
        }
        return ussd_end("Still under development. ");
    }

    private String  ussd_proceed(String ussd_text){
        return "CON "+ussd_text;
    }

    private String  ussd_end(String ussd_text){
        return "END "+ussd_text;
    }
}
