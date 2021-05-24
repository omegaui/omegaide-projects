package omega;
import java.util.*;
import java.io.*;
public class TestSudo {
     public static void main(String[] args){
     	try{
     		Scanner reader = new Scanner(new File("/usr/bin/omega-ide"));
               while(reader.hasNextLine())
                    System.out.println(reader.nextLine());
               reader.close();
     	}
     	catch(Exception e){ 
     		e.printStackTrace();
     	}
     }
}
