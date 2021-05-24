package omega;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.LinkedList;
import java.io.File;
import omega.instant.support.universal.*;
public class Main {
          private static String license = """
/**
  * <one line to give the program's name and a brief idea of what it does.>
  * Copyright (C) 2021 Omega UI

  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.

  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.

  * You should have received a copy of the GNU General Public License
  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
          """;
     
     public static void main(String[] args){
          File dir = new File("/home/ubuntu/Documents/Omega IDE/src");
          LinkedList<File> sources = new LinkedList<>();
          loadMySources(sources, dir);
          System.out.println("Writing License");
          sources.forEach(Main::appendLicense);
          System.out.println("Writing License ... Done!");
     }

     public static void appendLicense(File file){
          try{
          	String text = "";
               Scanner reader = new Scanner(file);
               while(reader.hasNextLine())
                    text += reader.nextLine() + "\n";
               reader.close();
               text = license + "\n" + text;
               PrintWriter writer = new PrintWriter(file);
               writer.println(text);
               writer.close();
          }
          catch(Exception e){ 
               e.printStackTrace();
          }
     }

     public static void loadMySources(LinkedList<File> sources, File dir){
     	File[] files = dir.listFiles();
          if(files == null || files.length == 0)
               return;
          for(File f : files){
               if(!f.isDirectory()){
                    if(f.getAbsolutePath().contains("/home/ubuntu/Documents/Omega IDE/src/omega"))
                         sources.add(f);
               }
               else
                    loadMySources(sources, f);
          }
     }
}
