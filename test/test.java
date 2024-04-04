
import static java.lang.System.console;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phoan
 */
public class test {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        
        LocalTime time = LocalTime.now();
        
        System.out.println("time:" + today + "-" + time);
        
        ArrayList arr = new ArrayList();
        for(int i=0; i<5;i++){
            arr.add(i);
        }
        
        System.out.println(arr.toString());
    }
}
