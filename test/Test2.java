
import Model.CongTac;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author phoan
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        LocalDateTime New = LocalDateTime.now();
        System.out.println(New);
        Date time = new Date(2022,11,11);
        saveFile(time);
        // TODO code application logic here
//        Integer i =1;
//        Integer j =2;
//        System.out.println(i.equals(j));

    }
     public static void saveFile(Date date) {
        try {
            FileWriter fos = new FileWriter("CongTac.txt");
            BufferedWriter bw = new BufferedWriter(fos);
            
           
                bw.write(date.toString());
                bw.newLine();
            
            
            bw.close();
            fos.close();
            
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
