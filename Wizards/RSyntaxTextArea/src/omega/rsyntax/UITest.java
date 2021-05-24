package omega.rsyntax;
import omega.token.factory.*;
import org.fife.ui.rsyntaxtextarea.*;
import java.awt.*;
import javax.swing.*;
public class UITest {
     public static void main(String[] args){
     	JFrame f = new JFrame();
          f.setSize(1000, 600);
          f.setLocationRelativeTo(null);

          RSyntaxTextArea textArea = new RSyntaxTextArea();
          MarkdownTokenMaker.apply(textArea);
          f.add(textArea, BorderLayout.CENTER);
          

          
          f.setVisible(true);
          
     }
}
