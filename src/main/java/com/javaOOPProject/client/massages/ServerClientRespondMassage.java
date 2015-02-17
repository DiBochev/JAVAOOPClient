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
public enum ServerClientRespondMassage {
    message0("no error"),
    message1("Username and/or password incorrect"),
    message2("dfdsdfedseredsx");  //login and get cards
    
    private final String message;
    
    private ServerClientRespondMassage (String message){
        this.message = message;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    /*
    how to call it!
    int i = 0;
    String a = "error" + i;
    System.out.println(ServerRespondMassage.valueOf(a).getMessage());
    */
}
