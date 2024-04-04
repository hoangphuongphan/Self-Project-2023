
package Model;

public class PhongBan {
    //field
    private int IDPhong;
    private String TenPhong;
    
    //constructer

    public PhongBan(int IDPhong, String TenPhong) {
        this.IDPhong = IDPhong;
        this.TenPhong = TenPhong;
    }

    public PhongBan() {
    }
    
    
    //get method

    public int getIDPhong() {
        return IDPhong;
    }

    public String getTenPhong() {
        return TenPhong;
    }
    
    //set method

    public void setIDPhong(int IDPhong) {
        this.IDPhong = IDPhong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }
    
    // other method

    @Override
    public String toString() {
        return "ID:" +this.IDPhong + "\nTen:" + this.TenPhong;
    }
    
    
    
    
}
