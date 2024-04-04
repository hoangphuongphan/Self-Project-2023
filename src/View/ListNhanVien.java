
package View;

import Controller.QuanLyNhanVien;
import Controller.QuanLyPhong;
import Model.NhanVien;
import java.util.ArrayList;
import java.util.Scanner;

public class ListNhanVien {
    private QuanLyNhanVien controller = new QuanLyNhanVien();
    
    private Scanner sc = new Scanner(System.in);
    
    private QuanLyPhong checkPhong = new QuanLyPhong();
    
    //-------------------------------------------------------------------------------------------
    private String[] Tong = {"Them Nhan Vien","Xoa Nhan Vien","Cap Nhat Thong Tin Nhan Vien","In Danh Sach","Luu va Thoat"};
    private String[] Xoa = {"Theo ten","Theo ID","Thoat"};
    private String[] Sua = {"Cap nhat phong ban","Cap nhat ten","Thoat"};
    //-------------------------------------------------------------------------------------------
    
    private Menu menu = new Menu("Quan Ly Nhan Vien",Tong) {
                @Override
                public void execute(int n) {
                    switch(n){
                        case 1:
                            controller.add(New());
                            break;
                        case 2:
                            menu1.run(3);
                            break;
                        case 3:
                            menu2.run(3);
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
    
    
    
    private Menu menu1 = new Menu("Xoa Nhan Vien",Xoa) {
        @Override
        public void execute(int n) {
            switch(n){
                case 1:
                    controller.deleteTen(scanName());
                    break;
                case 2:
                    controller.deleteID(scanIDDel());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Du lieu nhap khong hop le");
            }
        }
    };
    
    
    private Menu menu2 = new Menu("Cap Nhat Nhan Vien",Sua) {
        @Override
        public void execute(int n) {
            switch(n){
                case 1:
                    controller.updatePhong(scanIDDel(), scanIDPhong());
                    break;
                case 2:
                    controller.updateTen(scanIDDel(), scanName());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Du lieu nhap khong hop le");
            }
        }
    };
    //------------------------------------------------------------------------------------------
    
    public void run(){
//        controller.readFile();
        menu.run(5);
    }
    
    public void read(){
        controller.readFile();
    }
    //------------------------------------------------------------------------------------------
    private NhanVien New(){
        NhanVien temp = new NhanVien(scanID(),scanIDPhong(),scanName());
        return temp;
    }
    
    
    //------------------------------------------------------------------------------------------
    private int scanID(){
        int temp;
        do{
            System.out.println("Nhap ID cua nhan vien:");
            temp = Integer.parseInt(sc.nextLine());
        }while(controller.isExist(temp));
        
        return temp;
    }
    
    private int scanIDDel(){
        int temp;
        do{
            System.out.println("Nhap ID cua nhan vien:");
            temp = Integer.parseInt(sc.nextLine());
        }while(!controller.isExist(temp));
        
        return temp;
    }
    
    private String scanName(){
        
        System.out.println("Nhap ten cua nhan vien");
        
        String temp = sc.nextLine();
        return temp;
    }
    
    private int scanIDPhong(){
        int temp;
        
        do{
            System.out.println("Nhap ID phong cua nhan vien");
        
            temp = Integer.parseInt(sc.nextLine());
        
        }while(checkPhong.isxiseted(temp));
        
        return temp;
    }
    
}
