
package Model;

public class NhanVien {
    private int ID;
    private int Phong;
    private String Ten;
    
    
//    constructer

    public NhanVien(int ID, int Phong, String Ten) {
        this.ID = ID;
        this.Phong = Phong;
        this.Ten = Ten;
    }

    public NhanVien() {
    }
    
    
    
    
//    get method

    public int getID() {
        return ID;
    }

    public String getTen() {
        return Ten;
    }

    public int getPhong() {
        return Phong;
    }
    
    
//    set method

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPhong(int Phong) {
        this.Phong = Phong;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }


    // other method

    @Override
    public String toString() {
        return "ID:" +this.ID + "\nPhong:" +this.Phong + "\nTen:" + this.Ten;
    }
    
    
    
    
    
    
}
