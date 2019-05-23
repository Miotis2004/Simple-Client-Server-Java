/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiclientserverapp;

import static guiclientserverapp.Server.ReadFile;
import static guiclientserverapp.Server.WriteToFile;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 *
 * @author ravie
 */
public class ClientManager 
{
    public void converseWithClient(InputStream inStream, OutputStream outStream, ServerGUI sg) throws IOException, ClassNotFoundException
    {
        ObjectInputStream in = new ObjectInputStream(inStream);
        ObjectOutputStream out = new ObjectOutputStream(outStream);

        DataContainer request = (DataContainer) in.readObject();

        

        if (request.getReturnType() == 1) {
            ArrayList<DataContainer> myList = ReadFile(1);
            sg.DisplayMessage("Product List Requested ");
            out.writeObject(myList);
            out.flush();
        }else if (request.getReturnType() == 2) {
            ArrayList<DataContainer> myList = ReadFile(2);
            sg.DisplayMessage("Customer List Requested ");
            out.writeObject(myList);
            out.flush();
        }else if (request.getReturnType() == 0) {
            WriteToFile(request);
            sg.DisplayMessage("Writing Object to File ");
        }
    }
}
