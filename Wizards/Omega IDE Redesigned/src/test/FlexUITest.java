package test;
import omega.flexui.FlexLabel;
import omega.flexui.FlexButton;
import omega.flexui.FlexContainer;
import java.awt.Color;
import omega.flexui.FlexSwitch;
import javax.swing.JButton;
import omega.flexui.FlexFrame;

import static omega.flexui.ResourceManager.*;
public class FlexUITest {
     public static void main(String[] args){
          FlexFrame frame = new FlexFrame("Omega IDE");
          frame.setSize(1000, 600);
          frame.centerFrame();

          FlexContainer c = new FlexContainer(10, 5);
          c.setBounds(10, 100, 980, 60);
          frame.add(c);

          FlexButton b = new FlexButton(consoleImage);
          b.setBounds(10, 10, 40, 40);
          b.setArc(5, 5);
          c.add(b);
          
          frame.setVisible(true);
     }
}
