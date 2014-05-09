/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statusclass;

import javax.swing.JOptionPane;

/**
 *
 * @author dannnanng
 */
public class rooster {
    private String idPegawai;
    private String username;
    private String password;
    private String nama;
    
    public rooster(){
        
    }
    public rooster(String idPegawai, String username,String password ,String nama){
        this.idPegawai=idPegawai;
        this.username=username;
        this.password=password;
        this.nama=nama;
    }

    public void insert(String idPegawai, String username,String password, String nama){
       try{ 
        database db= new database();
        db.query("INSERT INTO rooster VALUES("+" "
                + "'"+idPegawai+"' , "+" "
                + "'"+username+"' , "
                + ""+" '"+password+"' , "
                + ""+" '"+nama+"' , "
                + ")");
        
       }catch(Throwable a){
           JOptionPane.showMessageDialog(null, a.getMessage());
       }
    }
    
    
    /**
     * @return the idPegawai
     */
    public String getIdPegawai() {
        return idPegawai;
    }

    /**
     * @param idPegawai the idPegawai to set
     */
    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }
    

    
}
