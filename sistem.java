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
    
    public void loadJadwal()  throws SQLException {
        database db=new database();
        ResultSet rs = db.getResultSet("select *from jadwal");
        while (rs.next()){
            jadwal j = new jadwal();
            j.setKdJadwal(rs.getString(1));
            j.setJam(rs.getInt(2));
            j.setMataKuliah(rs.getString(3));
            j.setDosen(rs.getString(4));
            j.setHari(rs.getInt(5));
            j.setNamaKelas(rs.getString(6));
            j.setKdRuang(rs.getString(7));
            getDaftarJadwal().add(j);
        }
        rs.close();
    }
    public void loadRuang () throws SQLException{
        database db=new database();
        ResultSet rs = db.getResultSet("select *from ruang");
        while (rs.next()){
            ruang r= new ruang();
            r.setIdRuang(rs.getString(1));
            r.setKapasitas(rs.getInt(2));
            getDaftarRuang().add(r);
        }
        rs.close();
    }
    public void loadRuangJadwal() throws SQLException{
        for (int i=0; i<getDaftarRuang().size();i++){
           for (int j=0; j<getDaftarJadwal().size();j++){
               if (getDaftarJadwal().get(i).getKdRuang().equals(getDaftarRuang().get(j).getIdRuang())){
                    getDaftarRuang().get(i).addJadwal(getDaftarJadwal().get(j));
               }
           }
        }
    }
    
    public void loadRooster() throws SQLException{
        database db=new database();
        ResultSet rs = db.getResultSet("select *from rooster");
        while (rs.next()){
            rooster a= new rooster();
            a.setIdPegawai(rs.getString(1));
            a.setUsername(rs.getString(2));
            a.setPassword(rs.getString(3));
            a.setNama(rs.getString(4));
            daftarRooster.add(a);
        }
        rs.close();
    }
    
    public jadwal carijadwal(String a) {
        for (int i=0; i<getDaftarJadwal().size();i++){
            if (a.equals(getDaftarJadwal().get(i).getKdJadwal())){
                return getDaftarJadwal().get(i);
            }
        }
        return null;
    }
    
    public ruang cariRuang (String a){
        for (int i=0;i<getDaftarJadwal().size();i++){
            if (a.equals(getDaftarRuang().get(i).getIdRuang())){
                return getDaftarRuang().get(i);
            }
        }
        return null;
    }
    
       public boolean cekloggin(String user, String Pass){
            boolean a= false;
            for (int i =0 ; i<daftarRooster.size();i++){
                if ((daftarRooster.get(i).getUsername().equals(user)) && (daftarRooster.get(i).getPassword().equals(Pass))){
                    a=true;
                }
            }
            return a;
       }

    /**
     * @return the daftarJadwal
     */
    public ArrayList<jadwal> getDaftarJadwal() {
        return daftarJadwal;
    }

    /**
     * @return the daftarRuang
     */
    public ArrayList<ruang> getDaftarRuang() {
        return daftarRuang;
    }
}
