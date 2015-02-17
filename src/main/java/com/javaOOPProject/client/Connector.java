/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaOOPProject.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fgg
 */
public class Connector {
    
    private String host;
    private int port;
    private Socket socket;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    
    public Connector(String host, int port){
        this.host = host;
        this.port = port;
    }
    
    public boolean isServerUp(){
        try {
            this.socket = new Socket(InetAddress.getByName(host), port);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
	
    public void sentRequestToServer(Client c) throws IOException {
        this.socket = new Socket(InetAddress.getByName(host), port);
        oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(XMLManager.createXML(c));
    }

    public String recieveMassageFromServer() throws IOException {
        ois = new ObjectInputStream(socket.getInputStream());
        String message = null;
        try {
            message = (String) ois.readObject();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return message;
    }
    
    public void closeSocket(){
        try {
            this.socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
