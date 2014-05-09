/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionListener;

/**
 *
 * @author initialD
 */
public interface interfaceView {
    public void addListener(ActionListener e);
    public void viewErrorMsg(String errorMsg);
    public void setVisible(boolean b);
}
