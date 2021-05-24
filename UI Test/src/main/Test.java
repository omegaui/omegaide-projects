package main;
import java.awt.*;
import javax.swing.*;
public class Test {
     public static void main(String[] args){
     	JFrame f = new JFrame();
          f.setSize(100, 100);
          f.setLocationRelativeTo(null);
          f.setVisible(true);

          FileDialog fd = new FileDialog(f);

          fd.setMode(FileDialog.LOAD);
          fd.show();
     }
}
