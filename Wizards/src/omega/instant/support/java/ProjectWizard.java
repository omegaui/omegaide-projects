package omega.instant.support.java;
import java.io.File;
import omega.comp.NoCaretField;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import omega.comp.TextComp;
import javax.swing.JFrame;

import static omega.utils.UIManager.*;
public class ProjectWizard extends JFrame{
     private TextComp titleComp;
     private TextComp projectNameLabel;
     private NoCaretField nameField;
     private TextComp jdkLabel;
     private TextComp jdkComp;
     private TextComp projectWorkspaceLabel;
     private TextComp projectWorkspaceComp;
     private TextComp jdkRootLabel;
     private TextComp jdkRootComp;
     private TextComp hintLabel;
     private TextComp closeComp;
     private TextComp createComp;

     private String hint1 = "Dependencies can be managed in the IDE";

     private int pressX;
     private int pressY;
     
     public ProjectWizard(){
     	super("Java Project Wizard");
          setUndecorated(true);
          JPanel panel = new JPanel(null);
          panel.setBackground(c2);
          setContentPane(panel);
          setBackground(c2);
          setSize(600, 335);
          setLocationRelativeTo(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          init();
          setVisible(true);
     }

     public void init(){
     	titleComp = new TextComp("Java Project Wizard", TOOLMENU_COLOR3_SHADE, TOOLMENU_COLOR3, c2, null);
          titleComp.setBounds(0, 0, getWidth(), 30);
          titleComp.setFont(PX14);
          titleComp.setArc(0, 0);
          titleComp.setClickable(false);
          titleComp.addMouseListener(new MouseAdapter(){
               @Override
               public void mousePressed(MouseEvent e){
               	pressX = e.getX();
                    pressY = e.getY();
               }
          });
          titleComp.addMouseMotionListener(new MouseAdapter(){
               @Override
               public void mouseDragged(MouseEvent e){
               	setLocation(e.getXOnScreen() - pressX, e.getYOnScreen() - pressY);
               }
          });
          add(titleComp);

          projectNameLabel = new TextComp("Project Name", TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, null);
          projectNameLabel.setBounds(10, 50, 150, 25);
          projectNameLabel.setFont(PX14);
          projectNameLabel.setClickable(false);
          add(projectNameLabel);

          nameField = new NoCaretField("", "Start Typing", TOOLMENU_COLOR3, c2, TOOLMENU_COLOR2);
          nameField.setBounds(170, 50, getWidth() - 190, 25);
          nameField.setFont(PX14);
          add(nameField);
          addKeyListener(nameField);

          jdkLabel = new TextComp("JDK Version", TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, null);
          jdkLabel.setBounds(10, 100, 150, 25);
          jdkLabel.setFont(PX14);
          jdkLabel.setClickable(false);
          add(jdkLabel);

          jdkComp = new TextComp("Select JDK", TOOLMENU_COLOR2_SHADE, c2, TOOLMENU_COLOR2, null);
          jdkComp.setBounds(170, 100, getWidth() - 190, 25);
          jdkComp.setFont(PX14);
          add(jdkComp);

          projectWorkspaceLabel = new TextComp("Workspace", TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, null);
          projectWorkspaceLabel.setBounds(10, 150, 150, 25);
          projectWorkspaceLabel.setFont(PX14);
          projectWorkspaceLabel.setClickable(false);
          add(projectWorkspaceLabel);

          projectWorkspaceComp = new TextComp("Select Workspace", TOOLMENU_COLOR1_SHADE, c2, TOOLMENU_COLOR1, null);
          projectWorkspaceComp.setBounds(170, 150, getWidth() - 190, 25);
          projectWorkspaceComp.setFont(PX14);
          add(projectWorkspaceComp);
          
          jdkRootLabel = new TextComp("JDK Root", TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, null);
          jdkRootLabel.setBounds(10, 200, 150, 25);
          jdkRootLabel.setFont(PX14);
          jdkRootLabel.setClickable(false);
          add(jdkRootLabel);

          jdkRootComp = new TextComp("Select JDK Root", TOOLMENU_COLOR1_SHADE, c2, TOOLMENU_COLOR1, null);
          jdkRootComp.setBounds(170, 200, getWidth() - 190, 25);
          jdkRootComp.setFont(PX14);
          add(jdkRootComp);

          hintLabel = new TextComp(hint1, TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, null);
          hintLabel.setBounds(10, 250, getWidth() - 20, 30);
          hintLabel.setClickable(false);
          hintLabel.setFont(PX14);
          add(hintLabel);

          closeComp = new TextComp("Close",  TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, ()->setVisible(false));
          closeComp.setBounds(10, 300, (getWidth() - 20)/2, 30);
          closeComp.setFont(PX14);
          add(closeComp);

          createComp = new TextComp("Create",  TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, this::create);
          createComp.setBounds((getWidth() - 20)/2 + 10, 300, (getWidth() - 20)/2, 30);
          createComp.setFont(PX14);
          add(createComp);
     }

     public void create(){
     	String projectName = nameField.getText();
          if(projectName == null || projectName.equals("")){
               hintLabel.setText("Please Specify a Project Name");
               return;
          }
          String workspace = projectWorkspaceComp.getToolTipText();
          if(workspace == null || workspace.equals("")){
               hintLabel.setText("Please Specify a Project Workspace");
               return;
          }
          File root = new File(workspace, projectName);
          if(root.exists()){
               hintLabel.setText("Project With this name already exists!");
               return;
          }

          //Creating Project Structure
          root.mkdir();
          new File(root, "bin").mkdir();
          new File(root, "out").mkdir();
          new File(root, "res").mkdir();
          new File(root, "src").mkdir();

          
     }

     public static void main(String[] args){
     	new ProjectWizard();
     }
}
