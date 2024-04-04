package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class HOP {
    //Field
    private int ID;
    private String NoiDung;
    private LocalDateTime ThoiGian;
    private Date TGDKSet;
    private int IDDangKy;
    private Date ThoiGianHop;
    private Date ThoiGianKetThuc;
    private int IDDiaDiem;
    private ArrayList<Integer> IDNVThamGia;
    
    
    //Constructer
    public HOP() {
        ThoiGian = LocalDateTime.now();
        ThoiGianHop = new Date();
        ThoiGianKetThuc = new Date();
        IDNVThamGia = new ArrayList();
    }

    public HOP(int ID, String NoiDung, int IDDangKy, Date ThoiGianHop, Date ThoiGianKetThuc, int IDDiaDiem,ArrayList IDNV) {
        this.ID = ID;
        this.NoiDung = NoiDung;
        this.ThoiGian = LocalDateTime.now();
        this.IDDangKy = IDDangKy;
        this.ThoiGianHop = ThoiGianHop;
        this.ThoiGianKetThuc = ThoiGianKetThuc;
        this.IDDiaDiem = IDDiaDiem;
        this.IDNVThamGia = IDNV;
    }
    
    public HOP(int ID, String NoiDung,Date TGDK, int IDDangKy, Date ThoiGianHop, Date ThoiGianKetThuc, int IDDiaDiem,ArrayList IDNV) {
        this.ID = ID;
        this.NoiDung = NoiDung;
        this.TGDKSet = TGDK;
        this.IDDangKy = IDDangKy;
        this.ThoiGianHop = ThoiGianHop;
        this.ThoiGianKetThuc = ThoiGianKetThuc;
        this.IDDiaDiem = IDDiaDiem;
        this.IDNVThamGia = IDNV;
    }
    
    //get method

    public int getID() {
        return ID;
    }

    public int getIDDangKy() {
        return IDDangKy;
    }

    public int getIDDiaDiem() {
        return IDDiaDiem;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public LocalDateTime getThoiGian() {
        return ThoiGian;
    }

    public Date getThoiGianKetThuc() {
        return ThoiGianKetThuc;
    }

    public Date getThoiGianHop() {
        return ThoiGianHop;
    }

    public ArrayList<Integer> getIDNVThamGia() {
        return IDNVThamGia;
    }
    
    
    
    //set method 
    
    
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setIDDangKy(int IDDangKy) {
        this.IDDangKy = IDDangKy;
    }

    public void setIDDiaDiem(int IDDiaDiem) {
        this.IDDiaDiem = IDDiaDiem;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public void setThoiGianHop(Date ThoiGianHop) {
        this.ThoiGianHop = ThoiGianHop;
    }

    public void setThoiGianKetThuc(Date ThoiGianKetThuc) {
        this.ThoiGianKetThuc = ThoiGianKetThuc;
    }

    public void setIDNVThamGia(ArrayList<Integer> IDNVThamGia) {
        this.IDNVThamGia = IDNVThamGia;
    }
    
    
    //other method

    @Override
    public String toString() {
        return "ID:" + this.IDDangKy + "(" + this.ID +")\nthoi gian hop:" + this.ThoiGianHop +"  ->  " 
        + this.ThoiGianKetThuc +"\ntai phong:" + this.IDDiaDiem + "\nNoi dung:" +this.NoiDung + "\nNhan Vien Tham gia"+ (this.IDNVThamGia).toString()+
        "\nTGDK:" +this.ThoiGian +"\n-------------------------------";
    }
    
    
    public String StringofFile() {
        
    }
    
    
    
    
}
