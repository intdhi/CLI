/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statusclass;

import javax.swing.JOptionPane;

/**
 *
 * @author initialD
 */
public class jadwal {
    private String kdJadwal;
    private int jam;
    private int hari;
    private String mataKuliah;
    private String dosen;
    private String namaKelas;
    private String kdRuang;
    
    public jadwal(){
    }
    public jadwal(String kdJadwal, int jam, String mataKuliah,String dosen,int hari,String namaKelas,String kdRuang){
        this.dosen=dosen;
        this.namaKelas=namaKelas;
        this.jam=jam;
        this.kdJadwal=kdJadwal;
        this.mataKuliah=mataKuliah;
        this.hari=hari;
        this.kdRuang=kdRuang;
    }
    
    public void insert(){
       try{ 
        database db= new database();
        db.query ("INSERT INTO jadwal values ('"+kdJadwal+"','"+jam+"','"+mataKuliah+"','"+dosen+"','"+hari+"','"+namaKelas+"','"+kdRuang+"')");
       }catch(Throwable a){
           JOptionPane.showMessageDialog(null, a.getMessage());
       }
    }
    
    public void viewJadwal(){
        System.out.println("kd jadwal : "+kdJadwal);
        System.out.println("mata kuliah  : "+mataKuliah);
        System.out.println("jam : "+jam);
        System.out.println("hari : "+hari);
        System.out.println("nama kelas : "+namaKelas);
    }
    
    /**
     * @return the kdJadwal
     */
    public String getKdJadwal() {
        return kdJadwal;
    }

    /**
     * @param kdJadwal the kdJadwal to set
     */
    public void setKdJadwal(String kdJadwal) {
        this.kdJadwal = kdJadwal;
    }

    /**
     * @return the jam
     */
    public int getJam() {
        return jam;
    }

    /**
     * @param jam the jam to set
     */
    public void setJam(int jam) {
        this.jam = jam;
    }

    /**
     * @return the mataKuliah
     */
    public String getMataKuliah() {
        return mataKuliah;
    }

    /**
     * @param mataKuliah the mataKuliah to set
     */
    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    /**
     * @return the dosen
     */
    public String getDosen() {
        return dosen;
    }

    /**
     * @param dosen the dosen to set
     */
    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    /**
     * @return the namaKelas
     */
    public String getNamaKelas() {
        return namaKelas;
    }

    /**
     * @param namaKelas the namaKelas to set
     */
    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    /**
     * @return the hari
     */
    public int getHari() {
        return hari;
    }

    /**
     * @param hari the hari to set
     */
    public void setHari(int hari) {
        this.hari = hari;
    }

    /**
     * @return the kdRuang
     */
    public String getKdRuang() {
        return kdRuang;
    }

    /**
     * @param kdRuang the kdRuang to set
     */
    public void setKdRuang(String kdRuang) {
        this.kdRuang = kdRuang;
    }
      

}
