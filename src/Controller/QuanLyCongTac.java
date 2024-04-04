/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CongTac;
import Model.NhanVien;
import Model.PhongBan;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author phoan
 */
public class QuanLyCongTac {
    private ArrayList<CongTac> congtac = new ArrayList();
    
    private QuanLyNhanVien valid = new QuanLyNhanVien();
    
//    ----------------------------------------------------------------------------
    
    public void readFile(){
        try {
            FileReader fis = new FileReader("CongTac.txt");
            BufferedReader br = new BufferedReader(fis);
            String line = br.readLine();;
            
            while(line != null){
                
                String arr[] = line.split(",");
                
                if (arr.length == 9){
                        congtac.add(new CongTac(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),arr[2],readDate(arr[3]),
                        readDate(arr[4]),arr[5],arr[6],Integer.parseInt(arr[7]),convertToLocal(readDate(arr[8]))));
                }else 
                    System.out.println("Thong tin phong khong hop le");
                
                line = br.readLine();
            }
            
            br.close();
            fis.close();

            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void saveFile() {
        try {
            FileWriter fos = new FileWriter("CongTac.txt");
            BufferedWriter bw = new BufferedWriter(fos);
            
            for(CongTac cong : congtac){
                bw.write(cong.getID() +","+ cong.getIDNhanVien() +","+ cong.getNoiDung() +","+ cong.getNgayBatDau() +","+ cong.getNgayKetThuc() 
                +","+ cong.getNoiCongTac() +","+ cong.getPhuongTien() +","+ cong.getIDDangKy() +","+ cong.getNgayDangKy());
                bw.newLine();
            }
            
            bw.close();
            fos.close();
            
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    ----------------------------------------------------------------------------
    
    public void add(CongTac Congtac){
            congtac.add(Congtac);
    }
    
    public void deleteID(int ID){
        CongTac congTac = new CongTac();
        if (congtac.isEmpty()) {
            System.out.println("khong ton tai lich cong tac");
        }else{
            boolean removed = false;
            
            for(CongTac c : congtac){
                if(c.getID() == ID){
                    congTac = c;
                    removed = true;
                    break;
                }
            }
            if (removed) {
                congtac.remove(congTac);
                System.out.println("Xoa Thanh Cong");
            } else {
                System.out.println("Lich Cong Tac " + ID + " khong tim thay");
            }
        }
    }
    
    public void deleteIdNhanVien(int IDNhanVien){
        CongTac congTac = new CongTac();
        if (congtac.isEmpty()) {
            System.out.println("khong ton tai lich cong tac");
        }else{
            boolean removed = false;
            
            for(CongTac c : congtac){
                if(c.getID() == IDNhanVien){
                    congTac = c;
                    removed = true;
                    break;
                }
            }
            if (removed) {
                congtac.remove(congTac);
                System.out.println("Xoa Thanh Cong");
            } else {
                System.out.println("Lich Cong Tac cua Nhan Vien " + IDNhanVien + " khong tim thay");
            }
        }
    }
    
    public void deleteThoiGianBatDau(Date time){
        CongTac congTac = new CongTac();
        if (congtac.isEmpty()) {
            System.out.println("khong ton tai lich cong tac");
        }else{
            boolean removed = false;
            
            for(CongTac c : congtac){
                if(c.getNgayBatDau().equals(time)){
                    congTac = c;
                    removed = true;
                    break;
                }
            }
            if (removed) {
                congtac.remove(congTac);
                System.out.println("Xoa Thanh Cong");
            } else {
                System.out.println("Lich Cong Tac " + time + " khong tim thay");
            }
        }
    }
    
    public void deletePhuongTien(String phuongtien){
        CongTac congTac = new CongTac();
        if (congtac.isEmpty()) {
            System.out.println("khong ton tai lich cong tac");
        }else{
            boolean removed = false;
            
            for(CongTac c : congtac){
                if(c.getPhuongTien().equals(phuongtien)){
                    congTac = c;
                    removed = true;
                    break;
                }
            }
            if (removed) {
                congtac.remove(congTac);
                System.out.println("Xoa Thanh Cong");
            } else {
                System.out.println("Lich Cong Tac theo phuong tien " + phuongtien + " khong tim thay");
            }
        }
    }
    
    public void deleteNoiCongTac(String diaDiem){
        CongTac congTac = new CongTac();
        if (congtac.isEmpty()) {
            System.out.println("khong ton tai lich cong tac");
        }else{
            boolean removed = false;
            
            for(CongTac c : congtac){
                if(c.getPhuongTien().equals(diaDiem)){
                    congTac = c;
                    removed = true;
                    break;
                }
            }
            if (removed) {
                congtac.remove(congTac);
                System.out.println("Xoa Thanh Cong");
            } else {
                System.out.println("Lich Cong Tac o " + diaDiem + " khong tim thay");
            }
        }
    }
    
    public void updateIDNhanVien(int ID, int IDNhanVien){
        CongTac congTac = new CongTac();
        if (congtac.isEmpty()) {
            System.out.println("khong ton tai lich cong tac");
        }else{
            boolean updated = false;
            
            for(CongTac c : congtac){
                if(c.getID() == ID){
                    congTac = c;
                    updated = true;
                    break;
                }
            }
            if (updated) {
                congTac.setIDNhanVien(IDNhanVien);
                System.out.println("Cap Nhat Thanh Cong");
            } else {
                System.out.println("Lich Cong Tac " + ID + " khong tim thay");
            }
        }
    }
    
    public void updateThoiGianBatDau(int ID, Date ThoiGianBatDau){
        CongTac congTac = new CongTac();
        if (congtac.isEmpty()) {
            System.out.println("khong ton tai lich cong tac");
        }else{
            boolean updated = false;
            
            for(CongTac c : congtac){
                if(c.getID() == ID){
                    congTac = c;
                    updated = true;
                    break;
                }
            }
            if (updated) {
                congTac.setNgayBatDau(ThoiGianBatDau);
                System.out.println("Cap Nhat Thanh Cong");
            } else {
                System.out.println("Lich Cong Tac " + ID + " khong tim thay");
            }
        }
    }
    
    public void updatePhuongTien(int ID, String phuongTien){
        CongTac congTac = new CongTac();
        if (congtac.isEmpty()) {
            System.out.println("khong ton tai lich cong tac");
        }else{
            boolean updated = false;
            
            for(CongTac c : congtac){
                if(c.getID() == ID){
                    congTac = c;
                    updated = true;
                    break;
                }
            }
            if (updated) {
                congTac.setPhuongTien(phuongTien);
                System.out.println("Cap Nhat Thanh Cong");
            } else {
                System.out.println("Lich Cong Tac " + ID + " khong tim thay");
            }
        }
    }
    
    public void updateNoiDung(int ID, String NoiDung){
        CongTac congTac = new CongTac();
        if (congtac.isEmpty()) {
            System.out.println("khong ton tai lich cong tac");
        }else{
            boolean updated = false;
            
            for(CongTac c : congtac){
                if(c.getID() == ID){
                    congTac = c;
                    updated = true;
                    break;
                }
            }
            if (updated) {
                congTac.setPhuongTien(NoiDung);
                System.out.println("Cap Nhat Thanh Cong");
            } else {
                System.out.println("Lich Cong Tac " + ID + " khong tim thay");
            }
        }
    }
    
    public void printList (){
        System.out.println("        Danh Sach Cong Tac");
        System.out.println("---------------------------------");
        if(congtac.size() ==0)
            System.out.println("         Trong");
        for(CongTac P : congtac){
            System.out.println(P.toString());
        }
    }
//    ----------------------------------------------------------------------------
    private Date readDate(String date){
        String[] line = date.split("/");
        int[] temp = new int[3];
        
        for(int i=0; i<line.length; i++){
            temp[i] = Integer.parseInt(line[i]);
        }
        
        return new Date(temp[0],temp[1],temp[2]);
    }
    
    private Date readTime(String date){
        String[] line = date.split("/");
        int[] temp = new int[5];
        
        for(int i=0; i<line.length; i++){
            temp[i] = Integer.parseInt(line[i]);
        }
        
        return new Date(temp[0],temp[1],temp[2],temp[3],temp[4]);
    }
    
    private LocalDateTime convertToLocal(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDateTime();
    }
    
//    ---------------------------------------validate-----------------------------
    
    public boolean isOccupied(int IDNhanVien){
        boolean isNotYet = false;
        
        for(CongTac Congtac : congtac){
            if(Congtac.getIDNhanVien()== IDNhanVien)
                isNotYet = true;
        }
        
        
        return isNotYet;
    }
    
    public boolean isExistID(int ID){
        boolean isExist = false;
        
        for(CongTac congTac : congtac){
            if(congTac.getID() == ID)
                isExist = true;
        }
        return isExist;
    }
}
