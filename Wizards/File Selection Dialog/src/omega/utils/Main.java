package omega.utils;
import java.util.LinkedList;
import java.io.File;
import javax.swing.*;
public class Main {
     public static void main(String[] args){
     	JFrame f = new JFrame();
          f.setSize(500, 400);
          f.setLocationRelativeTo(null);
          
          FileSelectionDialog fs = new FileSelectionDialog(f);
          f.setVisible(true);
          fs.setFileExtensions(FileSelectionDialog.ALL_EXTENSIONS);
          fs.setTitle("Select a File");
          LinkedList<File> files = fs.selectFilesAndDirectories();
          files.forEach(System.out::println);
     }
}
