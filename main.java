/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statusclass;

import Controller.handler;
import GUI.pertama;

/**
 *
 * @author initialD
 */
public class StatusClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       sistem model=new sistem();
       pertama view = new pertama();
       handler h = new handler();
        
       h.setModel(model);
       h.setView(view);
       h.setListener();
       view.setVisible(true);
        
    }
}
