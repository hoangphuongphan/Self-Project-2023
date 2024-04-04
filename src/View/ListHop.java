
package View;

import Controller.QuanLyCongTac;
import Controller.QuanLyLichHop;
import Controller.QuanLyNhanVien;
import Model.HOP;
import Model.NhanVien;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ListHop {
    private QuanLyLichHop controller = new QuanLyLichHop();
    
    private Scanner sc = new Scanner(System.in);
    
    private QuanLyNhanVien valid = new QuanLyNhanVien();   
    
    private QuanLyCongTac occupied = new QuanLyCongTac();
//    ----------------------------------------------------------------------------
    private int IdDangKy = 1;
    private String[] Tong = {"Tao Lich Hop Moi","Xoa Lich Hop","Cap Nhat Lich Hop","Hien Thi Lich Hop","Luu va Thoat"};
    private String[] Xoa = {"Xoa theo ID","Xoa theo thoi gian bat dau","Xoa theo ID phong","Thoat"};
    private String[] Sua = {"Cap nhat Thoi Gian hop","Cap nhat ID phong","Cap nhat noi dung hop","Thoat"};
//    ----------------------------------------------------------------------------
    
    private Menu menu = new Menu("Quan Ly Lich Hop",Tong) {
        @Override
        public void execute(int n) {
            switch(n){
                case 1:
                    controller.add(New());
                    break;
                case 2:
                    menu1.run(4);
                    break;
                case 3:
                    menu2.run(4); 
                    break;
                case 4:
                    controller.printList();
                    break;
                case 5:
                    controller.saveFile();
                    break;
                default:
                    System.out.println("Du lieu nhap khong hop le");
            }
        }
    };
    
    private Menu menu1 = new Menu("Xoa Lich Hop",Xoa) {
        @Override
        public void execute(int n) {
            switch(n){
                case 1:
                    controller.deleteID(scanID());
                    break;
                case 2:
                    controller.deleteTime(scanThoiGianBatDau());
                    break;
                case 3:
                    controller.deleteIDPhong(scanIDDiaDiem());
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Du lieu khong hop le");
            }
        }
    };
    
    private Menu menu2 = new Menu("Cap Nhat Lich Hop",Sua) {
        @Override
        public void execute(int n) {
            switch(n){
                case 1:
                    controller.updateTime(scanID(), scanThoiGianBatDau());
                    break;
                case 2:
                    controller.updateIdPhong(scanID(), scanIDDiaDiem());
                    break;
                case 3:
                    controller.updateNoiDung(scanID(), scanNoiDung());
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Du lieu nhap khong hop le");
            }
        }
    };
//    ----------------------------------------------------------------------------
    
    public void run(){
//        controller.readFile();
        menu.run(5);
    }
    
    public void read(){
        controller.readFile();
    }
//    ----------------------------------------------------------------------------
    
    private HOP New(){
        HOP temp = new HOP(scanID(),scanNoiDung(),IdDangKy,scanThoiGianBatDau(),
        scanThoiGianKetThuc(),scanIDDiaDiem(),scanIDThamGia());
        IdDangKy ++;
        return temp;
    }
//    ----------------------------------------------------------------------------
    
    private int scanID(){
        int temp;
        do{
            System.out.println("Nhap ID cuoc hop:");
            temp = Integer.parseInt(sc.nextLine());
        }while(controller.isExistID(temp));

        return temp;
    }
    
    private int scanIDDiaDiem(){
        System.out.println("Nhap ID dia diem cuoc hop");
        
        int temp = Integer.parseInt(sc.nextLine());
        return temp;
    }
    
    private Date scanThoiGianBatDau(){
        System.out.println("Nhap thoi gian bat dau(YYYY/MM/DD/HH/MM):");
        
        String temp = sc.nextLine();
        String[] arr = temp.split("/");
        Date tem = new Date(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),
        Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]));
        return tem;
    }
    
    private Date scanThoiGianKetThuc(){
        System.out.println("Nhap thoi gian ket thuc(YYYY/MM/DD/HH/MM):");
        
        String temp = sc.nextLine();
        String[] arr = temp.split("/");
        Date tem = new Date(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),
        Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]));
        return tem;
    }
    
    private String scanNoiDung(){
        System.out.println("Nhap Noi Dung cuoc hop:");
        
        String temp = sc.nextLine();
        return temp;
    }
    
    private ArrayList<Integer> scanIDThamGia(){
        System.out.println("Nhap ID cac nhan vien tham gia cuoc hop(nhap 0 de thoat)");
        
        ArrayList<Integer> temp = new ArrayList();
        String scan = sc.nextLine();
        
        while(scan.equals("0")){
            if (valid.isExist(Integer.parseInt(scan)) && !occupied.isOccupied(IdDangKy))
                temp.add(Integer.parseInt(scan));
            else
                System.out.println("Nhan Vien khong hop le");
            
        }
        
        return temp;
    }
}
