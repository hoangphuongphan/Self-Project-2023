/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author phoan
 */
public abstract class Menu<T> {
    protected String title;
    protected ArrayList<T> choices;

    public Menu(String title, String[] input) {
        this.title = title;
        this.choices = new ArrayList<T>();
        
        for(String choice : input) choices.add((T) choice);
        
    }
    
//    -----------------------------------------------------
    
    
    public void display(){
        System.out.println("        "+title+"        ");
        System.out.println("-------------------------------");  
        for(int i=0; i<choices.size();i++){
            System.out.println(  (i+1)  +  "."  +  choices.get(i));
        }
        System.out.println("-------------------------------");
        
        
    }
    
//    --------------------------------------------------------
    
    
    
    public int getSelection(){
        Scanner sc = new Scanner(System.in);
        
        display();
        
        System.out.println("Enter Option:");
        return sc.nextInt();
    }
    
//    ----------------------------------------------------------------
    
    
    public abstract void execute(int n);
    
    
//    ---------------------------------------------------
    
    
    public void run(int exit){
        int choice;
        do{
            choice = getSelection();
            execute(choice);
            
        }while(choice != exit);
    }
    
}
