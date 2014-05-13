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
        }catch (Throwable e){
          //  view.viewErrorMsg(e.getMessage());
        }
    }
    
    pertama pr;
    user us;
    roosterv ro;
    tambahJadwal tb;
    viewJadwal vj;
    viewJadwal1 vj1;
    
    
    //handler semua halaman 
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
            }else if (source.equals(us.getLihatJadwal())){       //user lihat ruang
                try {
                if (us.getkliktableRuang()!=null){ 
                    us.setVisible(false);
                    viewJadwal1 tbh= new viewJadwal1();
                    tbh.setRuang(us.getkliktableRuang());
                    setView(tbh);
                    setListener();
                    view.setVisible(true);
                }
                }catch (Throwable we){
                    //kalau belum ter-klik 
                }
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
            }else if (source.equals(ro.getLihatRuang())){       //rosster lihat ruang
                try {
                if (ro.getkliktableRuang()!=null){ 
                    ro.setVisible(false);
                    viewJadwal tbh= new viewJadwal();
                    tbh.setRuang(ro.getkliktableRuang());
                    setView(tbh);
                    setListener();
                    view.setVisible(true);
                }
                }catch (Throwable we){
                    //kalau belum ter-klik 
                }
            }else if (source.equals(ro.getHapusRuang())){    //rosster hapus ruang
                try {
                    String aq=ro.getkliktableRuang();
                    if (model.cariRuang(aq)!=null){
                        JOptionPane.showMessageDialog(null,"Hapus Ruang dengan id  "+ro.getkliktableRuang());
                        model.deleteRuang(model.cariRuang(aq));
                        lihatJadwal(ro);
                        lihatRuang(ro);
                    }
                }catch(Throwable a){
                  JOptionPane.showMessageDialog(null, "klik salah satu tabel");
                }
            }else if (source.equals(ro.getHapusJadwal())){    //rosster hapus ruang
                try {
                    String aq=ro.getkliktableJadwal();
                    if (model.carijadwal(aq)!=null){
                        JOptionPane.showMessageDialog(null,"Hapus jadwal dengan id  "+ro.getkliktableJadwal());
                        model.deleteJadwal(model.carijadwal(aq));
                        lihatJadwal(ro);
                        lihatRuang(ro);
                    }
                }catch(Throwable a){
                  JOptionPane.showMessageDialog(null, "klik salah satu tabel");
                }
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
       }else if (view instanceof viewJadwal){                //halaman lihat jadwal di ruang rooster
            vj= (viewJadwal) view;
            if (source.equals(vj.getBack())){  //tambah jadwal back 
                vj.setVisible(false);
                roosterv pr1= new roosterv();
                lihatRuang(pr1);
                lihatJadwal(pr1);
                setView(pr1);
                setListener();
                view.setVisible(true);
            }
       }else if (view instanceof viewJadwal1){      //halaman lihat jadwal di ruang hal user
            vj1= (viewJadwal1) view;
            if (source.equals(vj1.getBack())){  //tambah jadwal back 
                vj1.setVisible(false);
                user pr1= new user();
                lihatRuang(pr1);
                lihatJadwal(pr1);
                setView(pr1);
                setListener();
                view.setVisible(true);
            }
       }
}

    //action tambah jadwal
    public void tambahJadwalf(ActionEvent e){
        if (("".equals(tb.gettIdJadwal())) && ("".equals(tb.gettDosen())) && ("".equals(tb.gettIdJadwal())) &&("".equals(tb.gettIdRuang()))&&("".equals(tb.gettMK())) && ("".equals(tb.gettKelas()))) { 
            JOptionPane.showMessageDialog(null,"harap dilengkapi");
        }else {
            boolean b;
            b=model.cekRuang(tb.gettIdRuang());
            if (b==false){  
                boolean a2;
                a2=model.cekJadwal(tb.gettIdJadwal());
                if (a2==true){
                    boolean a3;
                        model.lihat();
                            jadwal j =new jadwal();
                            j.setKdJadwal(tb.gettIdJadwal());
                            j.setDosen(tb.gettDosen());
                            j.setHari(tb.gettChari());
                            j.setJam(tb.gettCjam());
                            j.setMataKuliah(tb.gettMK());
                            j.setKdRuang(tb.gettIdRuang());
                            j.setNamaKelas(tb.gettKelas());
                            model.addJadwal(j);
                            tb.setVisible(false);
                            roosterv pr1= new roosterv();
                            lihatRuang(pr1);
                            lihatJadwal(pr1);
                            setView(pr1);
                            setListener();
                            view.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"id jadwal sudah ada");
                }
            }else{
                JOptionPane.showMessageDialog(null,"id ruang tidak ada");
            }
        }  
    }


    
    //action halaman pertama
    public void pertamaf(ActionEvent e){
         Object source = e.getSource();
         pr=(pertama) view;
            if (source.equals(pr.getView())){
                pr.setVisible(false);
                user a= new user();
                lihatRuang(a);
                lihatJadwal(a);
             
                setView(a);
                setListener();
                view.setVisible(true);
            }else if (source.equals(pr.getLogin())){
                if(model.cekloggin(pr.getUsername(),pr.getPassword())==true){
                    pr.setVisible(false);
                    roosterv a= new roosterv();
                    lihatRuang(a);
                    lihatJadwal(a);
                    a.getEditJadwal().setEnabled(false);
                    setView(a);
                    setListener();
                    view.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"ada kesalahan");
                }
            }
    }


////////tampilkan data di rooster
    public void lihatRuang(roosterv r){
        DefaultTableModel modelo = (DefaultTableModel) r.getTableRuang().getModel(); 
        int s= r.getTableRuang().getRowCount(); 
        for (int i=0;i<s;i++){
            modelo.removeRow(0);
        }
        for (int i=0;i<model.getDaftarRuang().size();i++){
            modelo.addRow(new Object[]{model.getDaftarRuang().get(i).getIdRuang(),model.getDaftarRuang().get(i).getKapasitas()});
        }
    }
    
 /////tampikkan data di user
        public void lihatRuang(user r){
        DefaultTableModel modelo = (DefaultTableModel) r.getTableRuang().getModel(); 
        int s= r.getTableRuang().getRowCount(); 
        for (int i=0;i<s;i++){
            modelo.removeRow(0);
        }
        for (int i=0;i<model.getDaftarRuang().size();i++){
            modelo.addRow(new Object[]{model.getDaftarRuang().get(i).getIdRuang(),model.getDaftarRuang().get(i).getKapasitas()});
        }
    }
        
        
     /////tampikkan data di user
        public void lihatJadwal(user r){
        DefaultTableModel modelo = (DefaultTableModel) r.getTableJadwal().getModel(); 
        int s= r.getTableJadwal().getRowCount(); 
        for (int i=0;i<s;i++){
            modelo.removeRow(0);
        }
        for (int i=0;i<model.getDaftarJadwal().size();i++){
            modelo.addRow(new Object[]{model.getDaftarJadwal().get(i).getKdJadwal(),model.getDaftarJadwal().get(i).getMataKuliah(),
                                       model.getDaftarJadwal().get(i).getJam(),model.getDaftarJadwal().get(i).getHari(),
                                        model.getDaftarJadwal().get(i).getDosen(),model.getDaftarJadwal().get(i).getNamaKelas(),
                                        model.getDaftarJadwal().get(i).getKdRuang()});
        }
    }
        
        public void lihatJadwal(roosterv r){
        DefaultTableModel modelo = (DefaultTableModel) r.getTableJadwal().getModel(); 
        int s= r.getTableJadwal().getRowCount(); 
        for (int i=0;i<s;i++){
            modelo.removeRow(0);
        }
        for (int i=0;i<model.getDaftarJadwal().size();i++){
            modelo.addRow(new Object[]{model.getDaftarJadwal().get(i).getKdJadwal(),model.getDaftarJadwal().get(i).getMataKuliah(),
                                       model.getDaftarJadwal().get(i).getJam(),model.getDaftarJadwal().get(i).getHari(),
                                        model.getDaftarJadwal().get(i).getDosen(),model.getDaftarJadwal().get(i).getNamaKelas(),
                                        model.getDaftarJadwal().get(i).getKdRuang()});
        }
    }
    


}
