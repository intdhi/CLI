/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import GUI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import statusclass.jadwal;
import statusclass.rooster;
import statusclass.ruang;
import statusclass.sistem;

/**
 *
 * @author initialD
 */
public class handler implements ActionListener{
    private sistem model;
    private interfaceView view;
    
    public void setView(interfaceView view){
        this.view=view;
    }
    public void setListener(){
        view.addListener(this);
    }

    public void setModel(sistem model){
        this.model=model;
        try {
            model.loadRooster();
            model.loadJadwal();
            model.loadRuang();
            model.loadRuangJadwal();
        }catch (Throwable e){
          //  view.viewErrorMsg(e.getMessage());
        }
    }
    
    pertama pr;
    user us;
    roosterv ro;
    tambahJadwal tb;
    
