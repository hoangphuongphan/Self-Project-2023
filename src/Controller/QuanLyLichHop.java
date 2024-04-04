
package Controller;

import Model.HOP;
import Model.NhanVien;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class QuanLyLichHop {
    private ArrayList<HOP> hop = new ArrayList();
//    ----------------------------------------------------------------------------
    public void readFile(){
        try {
            FileReader fis = new FileReader("Hop.txt");
            BufferedReader br = new BufferedReader(fis);
            String line = br.readLine();
            
            while(line != null){
                
                String arr[] = line.split(",");
                
                if (arr.length == 9){
                    hop.add(new HOP(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[3]), readDate(arr[4]), readDate(arr[5]), Integer.parseInt(arr[6]), readIDNV(arr[7]), convertToLocal(readDate(arr[8]))));
                }else 
                    System.out.println("Thong tin cuoc hop khong hop le");
                
                line = br.readLine();
            }
            
            br.close();
            fis.close();

            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void saveFile() {
        try {
            FileWriter fos = new FileWriter("Hop.txt");
            BufferedWriter bw = new BufferedWriter(fos);
            
            for(HOP h : hop){
                bw.write(h.getID() +","+ h.getNoiDung()  +","+ h.getIDDangKy() +","+ h.getThoiGianHop() +","+ h.getThoiGianKetThuc() +","+ h.getIDDiaDiem() +","+ h.getIDNVThamGia().toString()+","+ h.getThoiGian());
                bw.newLine();
            }
            
            bw.close();
            fos.close();
            
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
//    ----------------------------------------------------------------------------
    public void add(HOP h){
        hop.add(h);
    }
    
    public void updateNoiDung(int ID, String value){
        HOP h = new HOP();
        if (hop.isEmpty()) {
            System.out.println("khong ton tai danh sach cuoc hop");
        }else{
            boolean updated = false;

            for(HOP Hop : hop){
                if(Hop.getID() == ID){
                    h = Hop;
                    updated = true;
                    break;
                }
            }
            if (updated) {
                h.setNoiDung(value);
                System.out.println("Cap Nhat Thanh Cong");
            } else {
                System.out.println("Cuoc hop " + ID + " khong tim thay");
            }
        }
    }
    
    public void updateIdPhong(int ID, int IDPhong){
        HOP h = new HOP();
        if (hop.isEmpty()) {
            System.out.println("khong ton tai danh sach cuoc hop");
        }else{
            boolean updated = false;

            for(HOP Hop : hop){
                if(Hop.getID() == ID){
                    h = Hop;
                    updated = true;
                    break;
                }
            }
            if (updated) {
                h.setIDDiaDiem(IDPhong);
                System.out.println("Cap Nhat Thanh Cong");
            } else {
                System.out.println("Cuoc hop " + ID + " khong tim thay");
            }
        }
    }
    
    public void updateTime(int ID,Date time){
        HOP h = new HOP();
        if (hop.isEmpty()) {
            System.out.println("khong ton tai danh sach cuoc hop");
        }else{
            boolean updated = false;

            for(HOP Hop : hop){
                if(Hop.getID() == ID){
                    h = Hop;
                    updated = true;
                    break;
                }
            }
            if (updated) {
                h.setThoiGianHop(time);
                System.out.println("Cap Nhat Thanh Cong");
            } else {
                System.out.println("Cuoc hop " + ID + " khong tim thay");
            }
        }
    }
    
    public void deleteIDPhong(int ID){
        HOP h = new HOP();
        if (hop.isEmpty()) {
            System.out.println("khong ton tai danh sach cuoc hop");
        }else{
            boolean removed = false;
            
            for(HOP Hop : hop){
                if(Hop.getIDDiaDiem()== ID){
                    h = Hop;
                    removed = true;
                    break;
                }
            }
            if (removed) {
                hop.remove(h);
                System.out.println("Xoa Thanh Cong");
            } else {
                System.out.println("Cuoc Hop o phong " + ID + " khong tim thay");
            }
        }
    }

    public void deleteTime(Date time){
        HOP h = new HOP();
        if (hop.isEmpty()) {
            System.out.println("khong ton tai danh sach cuoc hop");
        }else{
            boolean removed = false;
            
            for(HOP Hop : hop){
                if(Hop.getThoiGianHop().equals(time)){
                    h = Hop;
                    removed = true;
                    break;
                }
            }
            if (removed) {
                hop.remove(h);
                System.out.println("Xoa Thanh Cong");
            } else {
                System.out.println("Cuoc Hop vao luc " + time + " khong tim thay");
            }
        }
    }
    
    public void deleteID(int ID){
        HOP h = new HOP();
        if (hop.isEmpty()) {
            System.out.println("khong ton tai danh sach cuoc hop");
        }else{
            boolean removed = false;
            
            for(HOP Hop : hop){
                if(Hop.getID() == ID){
                    h = Hop;
                    removed = true;
                    break;
                }
            }
            if (removed) {
                hop.remove(h);
                System.out.println("Xoa Thanh Cong");
            } else {
                System.out.println("Cuoc hop " + ID + " khong tim thay");
            }
        }
    }
    
    public void printList(){
        System.out.println("        Danh Sach Cuoc Hop");
        System.out.println("---------------------------------");
        if(hop.size()<1)
            System.out.println("         Trong");
        for(HOP P : hop){
            System.out.println(P.toString());
        }
    }
    
//    ----------------------------------------------------------------------------
    private ArrayList<Integer> readIDNV(String IDNV){
        char[] temp = IDNV.toCharArray();
        ArrayList<Integer> ID = new ArrayList<>();
        
        for(char id : temp){
            if(Character.isDigit(id))
                ID.add(Character.getNumericValue(id));
        }
        return ID;
    }
    
    private Date readDate(String date){
        String[] line = date.split("/");
        int[] temp = new int[5];
        
        for(int i=0; i<line.length; i++){
            temp[i] = Integer.parseInt(line[i]);
        }
        
        return new Date(temp[0],temp[1],temp[2],temp[3],temp[4]);
    }
    
    private LocalDateTime convertToLocal(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDateTime();
    }

//    -----------------------------------------validate---------------------------
    
    public boolean isOccupied(int IDNhanVien){
        boolean isOccupied = false;
        
        for(HOP h : hop){
            ArrayList<Integer> temp = h.getIDNVThamGia();
             
            for(Integer i : temp){
                if(i == IDNhanVien)
                    isOccupied = true;
            }
        }
        
        return isOccupied;
    }
    
    public boolean isExistID(int ID){
        boolean isExist = false;
        
        for(HOP h : hop){
            if(h.getID() == ID)
                isExist = true;
        }
        return isExist;
    }
}
