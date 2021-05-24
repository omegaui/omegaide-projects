package omega.instant.support.java;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import omega.comp.TextComp;
import java.awt.Color;
import omega.comp.FlexPanel;
import javax.swing.JFrame;

import static omega.utils.UIManager.*;
public class Settings extends JFrame{
     private TextComp titleComp;
     private TextComp projectSpecificComp;
     private TextComp ideSpecificComp;

     private FlexPanel projectPanel;
     private TextComp jdkLabel;
     private TextComp jdkComp;

     private int pressX;
     private int pressY;
     private int state = 0;
     
     public Settings(){
          super("Java Preferences");
          setUndecorated(true);
          setSize(600, 500);
          setLocationRelativeTo(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setBackground(c2);
          JPanel panel = new JPanel(null);
          panel.setBackground(c2);
          setContentPane(panel);
          setLayout(null);
          init();
          setVisible(true);
     }

     public void init(){
     	titleComp = new TextComp("Java Preferences", TOOLMENU_COLOR3_SHADE, TOOLMENU_COLOR3, c2, null);
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

          projectSpecificComp = new TextComp("Project", TOOLMENU_COLOR1_SHADE, c2, TOOLMENU_COLOR1, ()->{
               state = 0;
               repaint();
          }){
               @Override
               public void draw(Graphics2D g){
                    if(state == 0)
                         g.fillRect(5, getHeight() - 4, getWidth() - 20, 4);
               }
          };
          projectSpecificComp.setArc(0, 0);
          projectSpecificComp.setBounds(10, 30, getWidth()/2, 40);
          projectSpecificComp.setFont(PX16);
          add(projectSpecificComp);

          ideSpecificComp = new TextComp("IDE", TOOLMENU_COLOR1_SHADE, c2, TOOLMENU_COLOR1, ()->{
               state = 1;
               repaint();
          }){
               @Override
               public void draw(Graphics2D g){
               	if(state == 1)
                         g.fillRect(5, getHeight() - 4, getWidth() - 20, 4);
               }
          };
          ideSpecificComp.setArc(0, 0);
          ideSpecificComp.setBounds(getWidth()/2, 30, getWidth()/2, 40);
          ideSpecificComp.setFont(PX16);
          add(ideSpecificComp);

          //Project
          projectPanel = new FlexPanel(null, c1, c3);
          projectPanel.setBounds(10, 80, getWidth() - 20, getHeight() - 90);
          projectPanel.setPaintGradientEnabled(true);
          add(projectPanel);
          
          jdkLabel = new TextComp("JDK Version", TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, null);
          jdkLabel.setBounds(10, 50, 100, 25);
          jdkLabel.setFont(PX14);
          jdkLabel.setClickable(false);
          projectPanel.add(jdkLabel);

          jdkComp = new TextComp("Select JDK", TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, null);
          jdkComp.setBounds(200, 50, projectPanel.getWidth() - 210, 25);
          jdkComp.setFont(PX14);
          projectPanel.add(jdkComp);
     }

     public static void main(String[] args){
     	new Settings();
     }
}
