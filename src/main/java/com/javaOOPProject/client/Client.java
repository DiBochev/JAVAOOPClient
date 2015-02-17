package com.javaOOPProject.client;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {

    @XmlElement(name = "username")
    private String username;
    @XmlElement(name = "password")
    private String password;
    @XmlElement(name = "cards")
    private ArrayList<Integer> cardNumbers;
    @XmlElement(name = "message")
    private String message;
    

    private Client(){}
    
    public Client(String username, String password, String message) {
        this.username = username;
        this.password = username + password;
        this.cardNumbers = null;
    }
    
    public void setMessage(String message){
        this.message = message;
    }

    public String getUsername() {
        return this.username;
    }
    
    public String getMessage(){
        return this.message;
    }
 
    public String getPassword() {
        return this.password;
    }
    
    public ArrayList<Integer> getCardNumbers(){
        return this.cardNumbers;
    }
}
