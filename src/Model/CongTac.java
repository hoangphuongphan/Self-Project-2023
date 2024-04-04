
package Model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CongTac {
    //field
    private int ID;
    private int IDNhanVien;
    private String NoiDung;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private String NoiCongTac;
    private String PhuongTien;
    private int IDDangKy;
    private LocalDateTime NgayDangKy;

    
    //constructer
    public CongTac() {
        NgayBatDau = new Date();
        NgayKetThuc = new Date();
        NgayDangKy = LocalDateTime.now();
    }

    public CongTac(int ID, int IDNhanVien, String NoiDung, Date NgayBatDau, Date NgayKetThuc, String NoiCongTac, String PhuongTien, int IDDangKy) {
        this.ID = ID;
        this.IDNhanVien = IDNhanVien;
        this.NoiDung = NoiDung;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.NoiCongTac = NoiCongTac;
        this.PhuongTien = PhuongTien;
        this.IDDangKy = IDDangKy;
        this.NgayDangKy = LocalDateTime.now();
    }
    
    public CongTac(int ID, int IDNhanVien, String NoiDung, Date NgayBatDau, Date NgayKetThuc, String NoiCongTac, String PhuongTien, int IDDangKy,LocalDateTime time) {
        this.ID = ID;
        this.IDNhanVien = IDNhanVien;
        this.NoiDung = NoiDung;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.NoiCongTac = NoiCongTac;
        this.PhuongTien = PhuongTien;
        this.IDDangKy = IDDangKy;
        this.NgayDangKy = time;
    }
    
    
    
    //get method
    public int getID() {
        return ID;
    }

    public int getIDDangKy() {
        return IDDangKy;
    }

    public int getIDNhanVien() {
        return IDNhanVien;
    }

    public String getNgayBatDau() {
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy/");

      
        String dateString = formatter.format(NgayBatDau);
        return dateString;
    }

    public String getNgayDangKy() {
       

        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy/hh/mm/ss");

       
        String dateString = NgayDangKy.format(formatter);
        return dateString;
    }

    public String getNgayKetThuc() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

      
        String dateString = formatter.format(NgayKetThuc);
        return dateString;
    }

    public String getNoiCongTac() {
        return NoiCongTac;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public String getPhuongTien() {
        return PhuongTien;
    }
    
    
    
    //set method

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setIDNhanVien(int IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }
    
    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public void setNoiCongTac(String NoiCongTac) {
        this.NoiCongTac = NoiCongTac;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public void setPhuongTien(String PhuongTien) {
        this.PhuongTien = PhuongTien;
    }
    
    
    //other method

    @Override
    public String toString() {
        return "ID:"+ this.ID + ".(" + this.IDDangKy +")\n"+ "Ngay dang ky:" + this.getNgayDangKy() +"\nID nhan vien:" +  this.IDNhanVien
        + "\ndia diem va thoi gian:" + this.NoiCongTac +"(" + this.getNgayBatDau() +"-"+ this.getNgayKetThuc() + ")\nPhuong tien:" + this.PhuongTien;
    }
    
}
