/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaOOPProject.client.regularExpressions;

/**
 *
 * @author fgg12
 */
public enum RegularExpressions {
   
    VALIDATE_PING("^([0-9]{1,4}|[1-5][0-9]{4}|6[0-4][0-9]{3}|65[0-4][0-9]{2}|655[0-2][0-9]|6553[0-5])$"),
    VALIDATE_IP_ADRESS("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$"),
    
    VALIDATE_USERNAME("^[a-z0-9_-]{3,15}$"),
    VALIDATE_PASSWORD("^[a-zA-Z0-9]{3,15}$");
    
    private final String regex;

    private RegularExpressions(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
    
}
