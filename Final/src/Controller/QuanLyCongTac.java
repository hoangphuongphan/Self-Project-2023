/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CongTac;
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
    
    public void add(CongTac Congtac){
        if(valid.isExist(Congtac.getIDNhanVien()))
            congtac.add(Congtac);
        else
            System.out.println("Nhan Vien khong ton tai");
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
                if(c.getIDNhanVien()== IDNhanVien){
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
                if(c.getNgayBatDau().equals(ThoiGianBatDau)){
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
                if(c.getPhuongTien().equals(phuongTien)){
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
                if(c.getPhuongTien().equals(NoiDung)){
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
        System.out.println("        Danh Sach Cuoc Hop");
        System.out.println("---------------------------------");
        if(congtac.size()<1)
            System.out.println("         Trong");
        for(CongTac P : congtac){
            System.out.println(P.toString());
        }
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
}
