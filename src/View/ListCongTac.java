/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.QuanLyCongTac;
import Controller.QuanLyLichHop;
import Controller.QuanLyNhanVien;
import Model.CongTac;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author phoan
 */
public class ListCongTac {
    private QuanLyCongTac controller = new QuanLyCongTac();
    
    private QuanLyNhanVien check = new QuanLyNhanVien();
    
    private QuanLyLichHop occupied = new QuanLyLichHop();
    
    private Scanner sc = new Scanner(System.in);
    
//    ----------------------------------------------------------------------------
    private int IDDangKy = 1;
    private String[] Tong ={"Tao Lich Cong Tac","Xoa Lich Cong Tac","Cap Nhat Lich Cong Tac","Hien Thi Lich Cong Tac","Luu va Thoat"};
    private String[] Xoa = {"Xoa theo ID","Xoa theo ID nhan vien","Xoa theo Thoi gian Bat Dau","Xoa theo phuong tien","Xoa theo noi cong tac","Thoat"};
    private String[] Sua = {"Cap Nhat ID nhan vien","Cap Nhat Thoi gian bat bat dau","Cap nhat phuong tien","Cap nhat theo noi dung cong tac","Thoat"};
//    ----------------------------------------------------------------------------
    
    private Menu menu = new Menu("Quan Ly Cong Tac",Tong) {
        @Override
        public void execute(int n) {
            switch(n){
                case 1:
                    controller.add(New());
                    break;
                case 2:
                    menu1.run(6);
                    break;
                case 3:
                    menu2.run(5);
                    break;
                case 4:
                    controller.printList();
                    break;
                case 5:
                    controller.saveFile();
                    break;
                default:
                    System.out.println("Du lieu khong hop le");
            }
        }
    };
    
    private Menu menu1 = new Menu("Xoa Lich Cong Tac",Xoa) {
        @Override
        public void execute(int n) {
            switch(n){
                case 1:
                    controller.deleteID(scanIDDel());
                    break;
                case 2:
                    controller.deleteIdNhanVien(scanIDNhanVienDel());
                    break;
                case 3:
                    controller.deleteThoiGianBatDau(scanNgayBatDau());
                    break;
                case 4:
                    controller.deletePhuongTien(scanPhuongTien());
                    break;
                case 5:
                    controller.deleteNoiCongTac(scanNoiCongTac());
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Du lieu nhap khong hop le");
            }
        }
    };
    
    private Menu menu2 = new Menu("Cap nhat lich cong tac",Sua) {
        @Override
        public void execute(int n) {
            switch(n){
                case 1:
                    controller.updateIDNhanVien(scanIDDel(), scanIDNhanVien());
                    break;
                case 2:
                    controller.updateThoiGianBatDau(scanIDDel(), scanNgayBatDau());
                    break;
                case 3:
                    controller.updatePhuongTien(scanIDDel(), scanPhuongTien());
                    break;
                case 4:
                    controller.updateNoiDung(scanIDDel(), scanNoiDung());
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Du lieu nhap khong hop le");
            }
        }
    };
//    ----------------------------------------------------------------------------
    
    public void run(){
        
        menu.run(5);
    }
    
    public void read(){
        controller.readFile();
    }
//    ----------------------------------------------------------------------------
    
    private CongTac New(){
        CongTac temp = new CongTac(scanID(),scanIDNhanVien(),scanNoiDung(),
        scanNgayBatDau(),scanThoiGianKetThuc(),scanNoiCongTac(),
        scanPhuongTien(),IDDangKy);
        return temp;
    }
//    ----------------------------------------------------------------------------
    
    private int scanID(){
        int temp;
        do{
            System.out.println("Nhap ID cong tac:");
            temp = Integer.parseInt(sc.nextLine());
        }while(controller.isExistID(temp));

        return temp;
    }
    
    private int scanIDDel(){
        int temp;
        do{
            System.out.println("Nhap ID cong tac:");
            temp = Integer.parseInt(sc.nextLine());
        }while(!controller.isExistID(temp));

        return temp;
    }
    
    private int scanIDNhanVien(){
        int temp;
        do{
            System.out.println("Nhap ID nhan vien cong tac");
            temp = Integer.parseInt(sc.nextLine());
        }while(check.isExist(IDDangKy) && !occupied.isOccupied(IDDangKy));

        return temp;
    }
    
    private int scanIDNhanVienDel(){
        int temp;
        do{
            System.out.println("Nhap ID nhan vien cong tac");
            temp = Integer.parseInt(sc.nextLine());
        }while(!check.isExist(IDDangKy));

        return temp;
    }
    
    private String scanNoiDung(){
        System.out.println("Nhap noi dung cong tac");
        
        String temp = sc.nextLine();
        return temp;
    }
    
    private Date scanNgayBatDau(){
        System.out.println("Nhap thoi gian bat dau(dd/mm/yyyy):");
        
        String temp = sc.nextLine();
        String[] arr = temp.split("/");
        Date tem = new Date(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),
        Integer.parseInt(arr[2]));
        return tem;
    }
    
    private Date scanThoiGianKetThuc(){
        System.out.println("Nhap thoi gian ket thuc(Ydd/mm/yyyy):");
        
        String temp = sc.nextLine();
        String[] arr = temp.split("/");
        Date tem = new Date(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),
        Integer.parseInt(arr[2]));
        return tem;
    }
    
    private String scanNoiCongTac(){
        System.out.println("Nhap noi cong tac:");
        
        String temp = sc.nextLine();
        return temp;
    }
    
    private String scanPhuongTien(){
        System.out.println("Nhap phuong tien cong tac:");
        
        String temp = sc.nextLine();
        return temp;
    }
}
