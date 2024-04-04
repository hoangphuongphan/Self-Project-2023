
package View;

import Controller.QuanLyPhong;
import Model.PhongBan;
import java.util.Scanner;

public class ListPhong {
    private QuanLyPhong controller = new QuanLyPhong();
    
    private Scanner sc = new Scanner(System.in);
//    ----------------------------------------------------------------------------
    private String[] Tong ={"Tao Phong moi","Xoa Phong","Cap Nhat Phong","In danh sach Phong","Luu va Thoat"};
    private String[] Xoa = {"Xoa theo ID","Xoa theo ten","thoat"};
    private String[] Sua = {"Sua ten phong","thoat"};
//    ----------------------------------------------------------------------------
    
    private Menu menu = new Menu("Quan Ly Phong Ban",Tong) {
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
                    menu2.run(2);
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
    
    private Menu menu1 = new Menu("Xoa Phong Ban",Xoa) {
        @Override
        public void execute(int n) {
            switch(n){
                case 1:
                    controller.deleteID(scanIDPhong());
                    break;
                case 2:
                    controller.deleteName(scanName());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Du lieu khong hop le");
            }
        }
    };
    
    private Menu menu2 = new Menu("Cap Nhat Phong Ban",Sua) {
        @Override
        public void execute(int n) {
            switch(n){
                case 1:
                    controller.updateName(scanIDPhong(), scanName());
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Du lieu khong hop le");
            }
        }
    };
//    ----------------------------------------------------------------------------
    
    public void run(){
        controller.readFile();
        menu.run(5);
    }
//    ----------------------------------------------------------------------------
    
    private PhongBan New(){
        PhongBan temp = new PhongBan(scanIDPhong(),scanName());
        return temp;
    }
//    ----------------------------------------------------------------------------
    private int scanIDPhong(){
        System.out.println("Nhap ID cua Phong:");
        
        int temp = Integer.parseInt(sc.nextLine());
        return temp;
    }
    
    private String scanName(){
        System.out.println("Nhap ten cua phong:");
        
        String temp = sc.nextLine();
        return temp;
    }
    
}
