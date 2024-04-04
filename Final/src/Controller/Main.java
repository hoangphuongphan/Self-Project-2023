
package Controller;

import View.ListNhanVien;
import View.SuperList;

public class Main {
    public static void main(String[] args) {
//        ------------------------luu y----------------
        System.out.println("danh sach phong ban vao file PhongBan.txt");
        System.out.println("danh sach nhan vien bao file NhanVien.txt");
//        ---------------------------------------------

        SuperList list = new SuperList();
        list.run();
                        
    }
}
