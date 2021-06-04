package omega.instant.support.universal;
import java.util.*;
import omega.comp.*;
import javax.swing.*;
import static omega.utils.UIManager.*;
public class UniversalSettingsWizard extends JFrame{
     private TextComp titleComp;
     private NoCaretField runField;
     private NoCaretField compileField;
     private TextComp runWorkDirComp;
     private TextComp compileWorkDirComp;
     private TextComp listMakerComp;
     public LinkedList<JComponent> lists = new LinkedList<>();
     public UniversalSettingsWizard(){
     	super("Universal Settings Wizard");
          setUndecorated(true);
          JPanel panel = new JPanel(null);
          panel.setBackground(c2);
          setContentPane(panel);
          setResizable(false);
          setSize(600, 500);
          setLocationRelativeTo(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          init();
          setVisible(true);
     }

     public void init(){
     	titleComp = new TextComp("Universal Settings Wizard", TOOLMENU_COLOR3, c2, c2, null);
          titleComp.setBounds(0, 0, getWidth(), 30);
          titleComp.setFont(PX14);
          titleComp.attachDragger(this);
          titleComp.setArc(0, 0);
          titleComp.setClickable(false);
          add(titleComp);

          TextComp label0 = new TextComp("Compile Command", TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, null);
          label0.setBounds(10, 50, 150, 25);
          label0.setFont(PX14);
          label0.setClickable(false);
          add(label0);

          runField = new NoCaretField("", "Enter Run Command", TOOLMENU_COLOR3, c2, TOOLMENU_COLOR2);
          runField.setBounds(180, 50, getWidth() - 320, 25);
          runField.setFont(PX14);
          add(runField);

          runWorkDirComp = new TextComp("Working Directory", "Choose Working Directory When Building", TOOLMENU_COLOR1_SHADE, c2, TOOLMENU_COLOR2, null);
          runWorkDirComp.setLocation(runField.getX() + runField.getWidth() + 5, 50);
          runWorkDirComp.setSize(getWidth() - runWorkDirComp.getX() - 10, 25);
          runWorkDirComp.setFont(PX14);
          add(runWorkDirComp);

          TextComp label1 = new TextComp("Run Command", TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, null);
          label1.setBounds(10, 100, 150, 25);
          label1.setFont(PX14);
          label1.setClickable(false);
          add(label1);

          compileField = new NoCaretField("", "Enter Compile Command", TOOLMENU_COLOR3, c2, TOOLMENU_COLOR2);
          compileField.setBounds(180, 100, getWidth() - 320, 25);
          compileField.setFont(PX14);
          add(compileField);

          compileWorkDirComp = new TextComp("Working Directory", "Choose Working Directory When Running", TOOLMENU_COLOR1_SHADE, c2, TOOLMENU_COLOR2, null);
          compileWorkDirComp.setLocation(runField.getX() + runField.getWidth() + 5, 100);
          compileWorkDirComp.setSize(getWidth() - compileWorkDirComp.getX() - 10, 25);
          compileWorkDirComp.setFont(PX14);
          add(compileWorkDirComp);

          listMakerComp = new TextComp("Add a List Maker", TOOLMENU_COLOR4_SHADE, c2, TOOLMENU_COLOR4, null);
          listMakerComp.setBounds(getWidth()/2 - 100, 150, 200, 25);
          listMakerComp.setFont(PX14);
          add(listMakerComp);
     }

     @Override
     public void setVisible(boolean value){
     	if(value){
               setSize(600, lists.isEmpty() ? 180 : (180 + (lists.size() > 6 ? 500 : (lists.size() * 30))));
               setLocationRelativeTo(null);
     	}
          super.setVisible(value);
     }

     public static void main(String[] args){
     	new UniversalSettingsWizard();
     }
}
