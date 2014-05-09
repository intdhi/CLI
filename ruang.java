/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statusclass;

import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author bimozaky
 */
public class ruang {
    private int kapasitas;
    private String idRuang;
    private ArrayList<jadwal> daftarJadwal;
    private String status;
    private String[][] shif= new String[6][6];
    
    public ruang(String idRuang,int kapasitas){
        this.idRuang=idRuang;
        daftarJadwal= new ArrayList<jadwal>();
        this.kapasitas=kapasitas;
    }
    
    public ruang(){
    }
    
    public ArrayList<jadwal> getDaftarJadwal() {
        return daftarJadwal;
    }

    /**
     * @param daftarJadwal the daftarJadwal to set
     */
    public void setDaftarJadwal(ArrayList<jadwal> daftarJadwal) {
        this.setDaftarJadwal(daftarJadwal);
    }

    
    public void addJadwal(jadwal j){
        getShif()[j.getHari()][j.getJam()]=j.getKdJadwal();
        j.setKdRuang(getIdRuang());
        getDaftarJadwal().add(j);
    }
    
    public void delJadwal(jadwal j){
        getDaftarJadwal().remove(j);
        getShif()[j.getJam()]=null;
    }
    
    public void editJadwal(jadwal j,int jam,int hari, String mataKuliah,String dosen,String namaKelas){
        j.setDosen(dosen);
        j.setHari(hari);
        j.setJam(jam);
        j.setMataKuliah(mataKuliah);
        j.setNamaKelas(namaKelas);
    }
    
    public void viewJadwal(){
        System.out.println("daftar jadwal ");
        for (int i=0;i<getDaftarJadwal().size();i++){
            System.out.println("id : "+getDaftarJadwal().get(i).getKdJadwal());
            System.out.println("shif : "+getDaftarJadwal().get(i).getJam());
            System.out.println("hari : "+getDaftarJadwal().get(i).getHari());
        }
    }
    public void viewRuang(){
        System.out.println("idRuang  :  "+this.getIdRuang());
        System.out.println("kapasitas  :  "+this.getKapasitas());
        viewJadwal();
    }
    
        
    public void insert(){
       try{ 
        database db= new database();
        db.query("INSERT INTO ruang values ('"+idRuang+"','"+kapasitas+"','')");
        
       }catch(Throwable a){
           JOptionPane.showMessageDialog(null, a.getMessage());
       }
    }

    /**
     * @return the shif
     */
    public String[][] getShif() {
        return shif;
    }

    /**
     * @param shif the shif to set
     */
    public void setShif(String[][] shif) {
        this.setShif(shif);
    }

    /**
     * @return the kapasitas
     */
    public int getKapasitas() {
        return kapasitas;
    }

    /**
     * @param kapasitas the kapasitas to set
     */
    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    /**
     * @return the idRuang
     */
    public String getIdRuang() {
        return idRuang;
    }

    /**
     * @param idRuang the idRuang to set
     */
    public void setIdRuang(String idRuang) {
        this.idRuang = idRuang;
    }




}
