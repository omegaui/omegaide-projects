package omega.instant.support.universal;
import java.io.File;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;
import omega.comp.NoCaretField;
import omega.comp.TextComp;
import javax.swing.JFrame;

import static omega.utils.UIManager.*;
public class UniversalProjectWizard extends JFrame{
     private TextComp titleComp;
     private TextComp projectNameLabel;
     private NoCaretField nameField;
     private TextComp projectWorkspaceLabel;
     private TextComp projectWorkspaceComp;
     private TextComp hintLabel;
     private TextComp closeComp;
     private TextComp createComp;
     
     private String hint1 = "Dependencies can be managed in the IDE";

     private int pressX;
     private int pressY;
     public UniversalProjectWizard(){
     	super("Universal Project Wizard");
          setUndecorated(true);
          JPanel panel = new JPanel(null);
          panel.setBackground(c2);
          setContentPane(panel);
          setBackground(c2);
          setSize(600, 235);
          setLocationRelativeTo(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          init();
          setVisible(true);
     }

     public void init(){
     	titleComp = new TextComp("Universal Project Wizard", TOOLMENU_COLOR3_SHADE, TOOLMENU_COLOR3, c2, null);
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

          projectWorkspaceLabel = new TextComp("Workspace", TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, null);
          projectWorkspaceLabel.setBounds(10, 100, 150, 25);
          projectWorkspaceLabel.setFont(PX14);
          projectWorkspaceLabel.setClickable(false);
          add(projectWorkspaceLabel);

          projectWorkspaceComp = new TextComp("Select Workspace", TOOLMENU_COLOR1_SHADE, c2, TOOLMENU_COLOR1, null);
          projectWorkspaceComp.setBounds(170, 100, getWidth() - 190, 25);
          projectWorkspaceComp.setFont(PX14);
          add(projectWorkspaceComp);

          hintLabel = new TextComp(hint1, TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, null);
          hintLabel.setBounds(10, 150, getWidth() - 20, 30);
          hintLabel.setClickable(false);
          hintLabel.setFont(PX14);
          add(hintLabel);

          closeComp = new TextComp("Close",  TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, ()->setVisible(false));
          closeComp.setBounds(10, 200, (getWidth() - 20)/2, 30);
          closeComp.setFont(PX14);
          add(closeComp);

          createComp = new TextComp("Create",  TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, this::create);
          createComp.setBounds((getWidth() - 20)/2 + 10, 200, (getWidth() - 20)/2, 30);
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

          root.mkdir();
     }

     public static void main(String[] args){
     	new UniversalProjectWizard();
     }
}
