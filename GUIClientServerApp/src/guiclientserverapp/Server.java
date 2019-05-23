/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiclientserverapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Ronald Joubert
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerGUI sg = new ServerGUI();
        sg.setVisible(true);
        
        ConnectionSettings connection = new ConnectionSettings();
        
        ServerSocket server = new ServerSocket(connection.portNumber);
        sg.DisplayMessage("Server Started");
        
        //Live code
        /*while(true)
        {
            Socket socket = server.accept();
            RunnableClientManager cm = new RunnableClientManager(socket.getInputStream(), socket.getOutputStream(), sg);
            Thread thread = new Thread(cm);
            thread.start();
            
        }
         */       
        
        //Test code
        int counter = 0;
        
        while(true)
        {
            Socket socket = server.accept();
            RunnableClientManager cm = new RunnableClientManager(socket.getInputStream(), socket.getOutputStream(), sg);
            Thread thread = new Thread(cm);
            thread.start();
            counter++;
            sg.DisplayMessage("New Connection Made " + counter);
        }
    }
    
    
    
    public static void WriteToFile(DataContainer obj)
    {
        boolean fileCreated = false;
        boolean isValid = false;
        String fileName = "";
        if (obj.getDataType() == 0) {
            fileName = "Customers.txt";
        }else if (obj.getDataType() == 1) {
            fileName = "Products.txt";
        }
        
        
        String outputString = obj.getObjectName();
        try
        {
            try
            {
                
                                
                //Create new file if file does not exist
                File newFile = new File(fileName);
                fileCreated = newFile.createNewFile();
                if (fileCreated)
                {
                    System.out.println("File Created.");
                    isValid = true;
                }else
                {
                    System.out.println("File already exists.");
                    isValid = true;
                }
            } 
            catch (Exception e)
            {
                System.out.println("Error: " + e);
                isValid = false;
            }
            
            if(isValid)
            {
                FileWriter fw = new FileWriter(fileName, true); //Selecting the true boolean flag forces the filewriter to append the record.  False would overwright.
                BufferedWriter bw = new BufferedWriter(fw);
                
                bw.write(outputString);
                bw.newLine();
                bw.close();
                
                
            }
        } 
        catch (IOException e)
        {
            System.out.println("Write to external file failed.");
            
        }
    }
    
    public static ArrayList<DataContainer> ReadFile(int dataType)
    {
        ArrayList<DataContainer> data = new ArrayList<DataContainer>();
        
        String fileName = "";
        
        if (dataType == 1) {
            fileName = "Products.txt";
        }else if (dataType == 2) {
            fileName = "Customers.txt";
        }
        
        try{
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);
            
            
            String line = br.readLine();
            
            while(line != null)
            {
            DataContainer obj = new DataContainer();
            obj.setObjectName(line);
            data.add(obj);
            line = br.readLine();
            }
        }
        catch(Exception e){
            System.out.println("Cannot read file. " + e);
        }
        
        return data;
    }
    
    
}
