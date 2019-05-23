/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiclientserverapp;

import static guiclientserverapp.ClientGUI.RetrieveObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ravie
 */
public class ClientLimit {
    
    
    public static void main(String[] args){
        ConnectionSettings connection = new ConnectionSettings();
        DataContainer dc = new DataContainer();
        int counter = 0;
        
        for (int i = 0; i < 50000; i++) {
            try 
            {
                Socket socket = new Socket(connection.hostAddress, connection.portNumber);
                
                if (socket.isConnected()) {
                    counter++;
                    
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                        
                    out.writeObject(dc);
                    out.flush();
                    System.out.println("Connection Count: " + counter);
                    socket.close();
                }
                
                
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
