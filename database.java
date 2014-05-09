/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package statusclass;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author initialD
 */
public class database {
    private Connection con=null;
    private Statement stat=null;
    
    public database (){
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/statusclass","root","");
            stat = (Statement) con.createStatement();
        }catch(Throwable e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    public ResultSet getResultSet (String a){
        ResultSet rs= null;
        try {
            rs=stat.executeQuery(a);
            
        }catch (Throwable e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
        
    public void query(String a){
        try{
            stat.executeUpdate(a);
        }catch(Throwable e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
