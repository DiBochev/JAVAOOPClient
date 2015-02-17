package com.javaOOPProject.client;

import java.io.IOException;
import java.net.UnknownHostException;

public class ClientMain {

	public static void main(String[] args) throws UnknownHostException, IOException {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new ClientView().setVisible(true);
                    }
                });
           }	
   }
