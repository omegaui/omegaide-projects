package omega;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javafx.application.Application;
public class RecordX extends JFrame{
     private int xtraOrdinaryIDE;
     private int helloWorld;
     public static void main(String[] args){
     	try{
     		Scanner reader = new Scanner(new File("/home/arham/Documents/Omega Projects/Jar Loader Mech/src/reserved_Words2.txt"));
               while(reader.hasNextLine()){
                    String token = reader.nextLine().trim();
                    System.out.println("tokenMap.put(\"" + token + "\", TokenTypes.FUNCTION);");
               }
               reader.close();
     	}
          /*
               Testing Rust Color Scheme
          */
     	catch(Exception e){ 
     		System.err.println(e);
     	}
     }
}
