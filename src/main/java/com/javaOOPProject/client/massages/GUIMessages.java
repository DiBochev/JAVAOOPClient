/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaOOPProject.client.massages;

/**
 *
 * @author fgg12
 */
public enum GUIMessages {

    WRONG_FORMAT_IP_ADRESS("The IP adress is with wrong format example: 111.111.111.111"),
    WRONG_FORMAT_PING("The ping you entered must be only digits between 1 and 65535"),
    WRONG_FORMAT_USERNAME("The username has forbidden symbols"),
    WRONG_FORMAT_PASSWORD("The password has forbidden symbols"),
    CANNOT_CONNECT_TO_SERVER("Cannot connect to the server, please try again later"),
    WRONG_USERNAME_AND_OR_PASSWORD("Username and/or password incorrect");

    private final String message;

    private GUIMessages(String message) {
        this.message = message;
    }

    public String getRegex() {
        return message;
    }

}
