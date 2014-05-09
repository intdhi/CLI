/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statusclass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author initialD
 */
public class sistem {
    private ArrayList<ruang> daftarRuang;
    private ArrayList<jadwal> daftarJadwal;
    private ArrayList<rooster> daftarRooster;
    
    public sistem (){
        daftarRuang= new ArrayList<ruang>();
        daftarJadwal= new ArrayList<jadwal>();
        daftarRooster = new ArrayList<rooster>();
    }
    
    public void addJadwal(jadwal j){
        try {
            j.insert();
            getDaftarJadwal().add(j);
            JOptionPane.showMessageDialog(null, "tambah data sukses");
         }catch(Throwable e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void addRuang(ruang r){
     try {
            r.insert();
            getDaftarRuang().add(r);
            JOptionPane.showMessageDialog(null, "tambah data sukses");
         }catch(Throwable e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void addRooster (rooster ro){
       try {
           ro.insert(null, null, null, null);
           daftarRooster.add(ro);
         }catch(Throwable e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void addDaftarJadwal(jadwal j, ruang r){
        if (cekRuang(j.getKdJadwal())){
            if (r.getShif()[j.getHari()][j.getJam()]==null){
                r.addJadwal(j);
            }
        }
    }
    
    public boolean cekRuang (String idRuang){
        boolean a=true;
        for (int i=0; i<getDaftarRuang().size();i++){
            if (getDaftarRuang().get(i).getIdRuang().equals(idRuang)){
                a=false;
            }
        }
        return a;
    }
    
    public boolean cekJadwal(String idJadwal){
        boolean a=true;
        for (int i=0;i<getDaftarJadwal().size();i++){
            if (getDaftarJadwal().get(i).getKdJadwal().equals(idJadwal)){
                a=false;
            }
         }
        return a;
    }
    
