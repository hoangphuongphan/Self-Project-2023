
package Controller;

import Model.NhanVien;
import View.ListNhanVien;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import static java.util.Collections.list;

public class QuanLyNhanVien {
    private ArrayList<NhanVien> nhanVien = new ArrayList();
    
//    ----------------------------------------------------------------------------

    public ArrayList<NhanVien> getNhanVien() {
        return nhanVien;
    }
    
//    ----------------------------------------------------------------------------
    public void readFile(){
        try {
            FileInputStream fis = new FileInputStream("NhanVien.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();;
            
            while(line != null){
                
                String arr[] = line.split(",");
                
                if (arr.length == 3){
                    nhanVien.add(new NhanVien(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),arr[2]));
                }else 
                    System.out.println("Thong tin nhan vien khong hop le");
                
                line = br.readLine();
            }
            
            br.close();
            isr.close();
            fis.close();

            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void saveFile() {
        try {
            FileOutputStream fos = new FileOutputStream("NhanVien.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            
            for(NhanVien nhanvien : nhanVien){
                bw.write(nhanvien.getID() + "," + nhanvien.getPhong() + "," + nhanvien.getTen());
                bw.newLine();
            }
            
            bw.close();
            osw.close();
            fos.close();
            
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
//    ----------------------------------------------------------------------------
    
    public void add(NhanVien p){
            nhanVien.add(p);
    }

    public void deleteID(int ID){
        NhanVien nv = new NhanVien();
        if (nhanVien.isEmpty()) {
            System.out.println("khong ton tai danh sach nhan vien");
        }else{
            boolean removed = false;

            for(NhanVien nhanvien : nhanVien){
                if(nhanvien.getID() == ID){
                    nv = nhanvien;
                    removed = true;
                    break;
                }
            }
            if (removed) {
                nhanVien.remove(nv);
                System.out.println("Xoa Thanh Cong");
            } else {
                System.out.println("Nhan Vien " + ID + " khong tim thay");
            }
        }
    }
    
    public void deleteTen(String name){
        NhanVien nv = new NhanVien();
        if (nhanVien.isEmpty()) {
            System.out.println("khong ton tai danh sach nhan vien");
        }else{
            boolean removed = false;

            for(NhanVien nhanvien : nhanVien){
                if(nhanvien.getTen().equals(name)){
                    nv = nhanvien;
                    removed = true;
                    break;
                }
            }
            if (removed) {
                nhanVien.remove(nv);
                System.out.println("Xoa Thanh Cong");
            } else {
                System.out.println("Nhan Vien " + name + " khong tim thay");
            }
        }
    }
    
    public void updatePhong(int ID,int value){
        NhanVien nv = new NhanVien();
        if (nhanVien.isEmpty()) {
            System.out.println("khong ton tai danh sach nhan vien");
        }else{
            boolean updated = false;

            for(NhanVien nhanvien : nhanVien){
                if(nhanvien.getID() == ID){
                    nv = nhanvien;
                    updated = true;
                    break;
                }
            }
            if (updated) {
                nv.setPhong(value);
                System.out.println("Cap Nhat Thanh Cong");
            } else {
                System.out.println("Nhan Vien " + ID + " khong tim thay");
            }
        }
    }
    
    public void updateTen(int ID, String value){
        NhanVien nv = new NhanVien();
        if (nhanVien.isEmpty()) {
            System.out.println("khong ton tai danh sach nhan vien");
        }else{
            boolean updated = false;

            for(NhanVien nhanvien : nhanVien){
                if(nhanvien.getID() == ID){
                    nv = nhanvien;
                    updated = true;
                    break;
                }
            }
            if (updated) {
                nv.setTen(value);
                System.out.println("Cap Nhat Thanh Cong");
            } else {
                System.out.println("Nhan Vien " + ID + " khong tim thay");
            }
        }
    }
    
    public void printList(){
        System.out.println("        Danh Sach Nhan Vien");
        System.out.println("---------------------------------");
        if(nhanVien.size()<1)
            System.out.println("         Trong");
        for(NhanVien P : nhanVien){
            System.out.println(P.toString());
        }
        System.out.println("---------------------------------");
    }    
//    -----------------------------validate---------------------------------------
    
    public boolean isExist(int IDNhanVien){
        boolean isExist = false;
        
        for(NhanVien nhanvien : nhanVien){
            if(nhanvien.getID() == IDNhanVien)
                isExist = true;
        }
        
        return isExist;
    }
    
    public boolean isNotYetHop(int IDNhanVien){
        boolean isNotYet = false;
        NhanVien nv = new NhanVien();
        
        for(NhanVien nhanvien : nhanVien){
            if(nhanvien.getID() == IDNhanVien)
                nv =nhanvien;
        }
        
        
        return isNotYet;
    }
}
