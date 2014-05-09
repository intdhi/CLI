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
    
        @Override
    public void actionPerformed (ActionEvent e){
        Object source = e.getSource();
        if (view instanceof pertama){
            pertamaf(e);
        }else if (view instanceof user){                //halaman user
            us = (user) view;
            if (source.equals(us.getKembali())){
                us.setVisible(false);
                pertama pr1=new pertama();
                setView(pr1);
                setListener();
                pr1.setVisible(true);
            }
        }else if (view instanceof roosterv){                   //halaman rooster
            ro= (roosterv) view;
            if (source.equals(ro.getKembali())){ //rooster back kembali
                ro.setVisible(false);
                pertama pr1= new pertama();
                setView(pr1);
                setListener();
                view.setVisible(true);
            }else if (source.equals(ro.getTambahRuang())){      //rooster tambah ruang
                if ((ro.getTIdRuang()!=null) && (ro.getTKapasitas()>0)){
                    boolean a2;
                    a2=model.cekRuang(ro.getTIdRuang());
                    if (a2==true){
                        ruang a3= new ruang();
                        a3.setIdRuang(ro.getTIdRuang());
                        a3.setKapasitas(ro.getTKapasitas());
                        model.addRuang(a3);
                        lihatRuang(ro);
                    }else{
                        JOptionPane.showMessageDialog(null,"id sudah ada");
                    }
                }
            }else if (source.equals(ro.getTambahJadwal())){   //rosster tambah jadwal
                ro.setVisible(false);
                tambahJadwal tbh= new tambahJadwal();
                setView(tbh);
                setListener();
                view.setVisible(true);
            }  
       }else if (view instanceof tambahJadwal){                //halaman tambah jadwal
            tb= (tambahJadwal) view;
            if (source.equals(tb.getBack())){  //tambah jadwal back 
                tb.setVisible(false);
                roosterv pr1= new roosterv();
                lihatRuang(pr1);
                lihatJadwal(pr1);
                setView(pr1);
                setListener();
                view.setVisible(true);
            }if (source.equals(tb.gettTambah())){
                tambahJadwalf(e);  //fungsi tambah jadwal
            }
       }
}
    
