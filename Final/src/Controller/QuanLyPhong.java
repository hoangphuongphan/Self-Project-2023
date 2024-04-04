
package Controller;

import Model.NhanVien;
import Model.PhongBan;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class QuanLyPhong {
    private PhongBan Phongban = new PhongBan();
    
    private ArrayList<PhongBan> phong = new ArrayList();
//    ----------------------------------------------------------------------------
    public void readFile(){
        try {
            FileInputStream fis = new FileInputStream("PhongBan.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = br.readLine();;
            
            while(line != null){
                
                String arr[] = line.split(",");
                
                if (arr.length == 3){
                    phong.add(new PhongBan(Integer.parseInt(arr[0]),arr[1]));
                }else 
                    System.out.println("Thong tin phong khong hop le");
                
                line = br.readLine();
            }
            
            br.close();
            isr.close();
            fis.close();

            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void saveFile() {
        try {
            FileOutputStream fos = new FileOutputStream("PhongBan.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            
            for(PhongBan phongban : phong){
                bw.write(phongban.getIDPhong()+ "," + phongban.getTenPhong() );
                bw.newLine();
            }
            
            bw.close();
            osw.close();
            fos.close();
            
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
//    ----------------------------------------------------------------------------
    public void add(PhongBan Phong){
        phong.add(Phong);
    }
    
    public void deleteID(int ID){
        PhongBan Phong = new PhongBan();
        if (phong.isEmpty()) {
            System.out.println("khong ton tai danh sach nhan vien");
        }else{
            boolean removed = false;

            for(PhongBan p : phong){
                if(p.getIDPhong() == ID){
                    Phong = p;
                    removed = true;
                    break;
                }
            }
            if (removed) {
                phong.remove(Phong);
                System.out.println("Xoa Thanh Cong");
            } else {
                System.out.println("Phong " + ID + " khong tim thay");
            }
        }
    }
    
    public void deleteName(String name){
        PhongBan Phong = new PhongBan();
        if (phong.isEmpty()) {
            System.out.println("khong ton tai danh sach nhan vien");
        }else{
            boolean removed = false;

            for(PhongBan p : phong){
                if(p.getTenPhong().equals(name)){
                    Phong = p;
                    removed = true;
                    break;
                }
            }
            if (removed) {
                phong.remove(Phong);
                System.out.println("Xoa Thanh Cong");
            } else {
                System.out.println("Phong " + name + " khong tim thay");
            }
        }
    }
    
    public void updateName(int ID,String name){
        PhongBan Phong = new PhongBan();
        if (phong.isEmpty()) {
            System.out.println("khong ton tai danh sach nhan vien");
        }else{
            boolean removed = false;

            for(PhongBan p : phong){
                if(p.getIDPhong() == ID){
                    Phong = p;
                    removed = true;
                    break;
                }
            }
            if (removed) {
                Phong.setTenPhong(name);
                System.out.println("Cap Nhat Thanh Cong");
            } else {
                System.out.println("Phong " + ID + " khong tim thay");
            }
        }
    }
    
    public void printList(){
        System.out.println("        Danh Sach Phong Ban");
        System.out.println("---------------------------------");
        if(phong.size()<1)
            System.out.println("         Trong");
        for(PhongBan P : phong){
            System.out.println(P.toString());
        }
        System.out.println("---------------------------------");
    }
    
//    ---------------------------------------validate-----------------------------
    
    public boolean isxiseted(int ID){
        boolean exist = false;
        
        for(PhongBan phongban : phong){
            if(phongban.getIDPhong() == ID)
                exist = true;
        }
        
        return exist;
    }
}
