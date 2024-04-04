
package View;


public class SuperList {
    ListHop hop = new ListHop();
    
    ListNhanVien nhanVien = new ListNhanVien();
    
    ListPhong phong = new ListPhong();
    
    ListCongTac cong = new ListCongTac();
        
//    ----------------------------------------------------------------------------
    private String[] Tong ={"Quan Ly Nhan Vien","Quan Ly Phong Ban","Quan Ly Lich Hop","Quan Ly Cong Tac","Thoat"};
//    ----------------------------------------------------------------------------
    
    private Menu menu = new Menu("Quan Ly Cong Ty", Tong) {
        @Override
        public void execute(int n) {
            switch(n){
                case 1:
                    nhanVien.run();
                    break;
                case 2:
                    phong.run();
                    break;
                case 3:
                    hop.run();
                    break;
                case 4:
                    cong.run();
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
        cong.read();
        hop.read();
        phong.read();
        nhanVien.read();
        menu.run(5);
    }
}
