 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiclientserverapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ravie
 */
public class RunnableClientManager implements Runnable{

    private InputStream in;
    private OutputStream out;
    private ServerGUI sg;

    public RunnableClientManager(InputStream in, OutputStream out, ServerGUI sg) {
        this.in = in;
        this.out = out;
        this.sg = sg;
    }
    
    
    
    @Override
    public void run() {
        ClientManager manager = new ClientManager();
        
        try {
            manager.converseWithClient(in, out, sg);
        } catch (IOException ex) {
            Logger.getLogger(RunnableClientManager.class.getName()).log(Level.SEVERE, null, ex);
            sg.DisplayMessage("IO Exception ");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RunnableClientManager.class.getName()).log(Level.SEVERE, null, ex);
            sg.DisplayMessage("Class not Found Exception ");
        }
        
    }
    
    
    
}
