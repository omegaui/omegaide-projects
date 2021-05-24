package omega.utils;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.LinkedList;
import javax.swing.JScrollPane;
import java.awt.image.BufferedImage;
import omega.comp.TextComp;
import javax.swing.JPanel;
import omega.comp.FlexPanel;
import javax.swing.JFrame;
import static omega.utils.UIManager.*;
public class Launcher extends JFrame{

     private FlexPanel leftPanel;
     private JPanel rightPanel;
     private JScrollPane scrollPane;
     private int pressX;
     private int pressY;

     private LinkedList<TextComp> items = new LinkedList<>();
     
     public Launcher(){
     	super("Launcher");
          setUndecorated(true);
          setSize(700, 400);
          setLocationRelativeTo(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          JPanel panel = new JPanel(null);
          panel.setBackground(c2);
          setContentPane(panel);
          setBackground(c2);
          setLayout(null);
          init();
          setVisible(true);
     }

     public void init(){
          TextComp closeComp = new TextComp(IconManager.fluentcloseImage, 25, 25, "Click to Close", TOOLMENU_COLOR2_SHADE, c2, TOOLMENU_COLOR2, ()->System.exit(0));
          closeComp.setBounds(0, 0, 30, 30);
          closeComp.setArc(0, 0);
          add(closeComp);
          
     	TextComp imageComp = new TextComp((BufferedImage)IconManager.getImageIcon("/omega_ide_icon128.png").getImage(), 128, 128, c2, c2, c2, null);
          imageComp.setBounds(50, 50, 200, 150);
          imageComp.setClickable(false);
          imageComp.addMouseListener(new MouseAdapter(){
               @Override
               public void mousePressed(MouseEvent e){
                    pressX = e.getX();
                    pressY = e.getY();
               }
          });
          imageComp.addMouseMotionListener(new MouseAdapter(){
               @Override
               public void mouseDragged(MouseEvent e){
                    setLocation(e.getXOnScreen() - pressX - 50, e.getYOnScreen() - pressY - 50);
               }
          });
          add(imageComp);

          leftPanel = new FlexPanel(null, TOOLMENU_COLOR2, TOOLMENU_COLOR1);
          leftPanel.setPaintGradientEnabled(true);
          leftPanel.setBounds(50, 200, 200, getHeight() - 210);
          add(leftPanel);

          //Left Final Components
          TextComp openComp = new TextComp("Open a Project", TOOLMENU_COLOR3, TOOLMENU_COLOR3_SHADE, c2, null);
          openComp.setBounds(10, 10, 180, 25);
          openComp.setFont(PX14);
          leftPanel.add(openComp);
          
          TextComp njComp = new TextComp("New Java Project", TOOLMENU_COLOR3, TOOLMENU_COLOR3_SHADE, c2, null);
          njComp.setBounds(10, 40, 180, 25);
          njComp.setFont(PX14);
          leftPanel.add(njComp);
          
          TextComp nuComp = new TextComp("New Universal Project", TOOLMENU_COLOR3, TOOLMENU_COLOR3_SHADE, c2, null);
          nuComp.setBounds(10, 70, 180, 25);
          nuComp.setFont(PX14);
          leftPanel.add(nuComp);
          
          TextComp allComp = new TextComp("All Projects", TOOLMENU_COLOR3, TOOLMENU_COLOR3_SHADE, c2, null);
          allComp.setBounds(10, 100, 180, 25);
          allComp.setFont(PX14);
          leftPanel.add(allComp);
          
          TextComp workComp = new TextComp("Change Workspace", TOOLMENU_COLOR3, TOOLMENU_COLOR3_SHADE, c2, null);
          workComp.setBounds(10, 130, 180, 25);
          workComp.setFont(PX14);
          leftPanel.add(workComp);

          TextComp recentComp = new TextComp("About", TOOLMENU_COLOR3, TOOLMENU_COLOR3_SHADE, c2, null);
          recentComp.setBounds(10, 160, 180, 25);
          recentComp.setFont(PX14);
          leftPanel.add(recentComp);
          
          //Right Panel
          scrollPane = new JScrollPane(rightPanel = new JPanel(null));
          scrollPane.setBounds(300, 0, getWidth() - 300, getHeight());
          scrollPane.setBackground(c2);
          rightPanel.setBackground(c2);
          add(scrollPane);
     }

     public void resolveItems(){
     	TextComp comp = new TextComp("Omega IDE FX", "<path>", TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, null){
               @Override
               public void draw(Graphics2D g){
               	g.drawImage(IconManager.fluentfolderImage, 5, getHeight()/2 - 25/2, 25, 25, this);
               }
	     };
          comp.alignX = 60;
          comp.setBounds(0, 0, 400, 60);
          comp.setFont(PX16);
          comp.setArc(0, 0);
          items.add(comp);
          rightPanel.add(comp);
          rightPanel.setPreferredSize(new Dimension(395, 100));
     }

     @Override
     public void setVisible(boolean value){
     	if(value){
               resolveItems();
               setSize(items.isEmpty() ? 300 : 700, 400);
               setLocationRelativeTo(null);
     	}
          super.setVisible(value);
     }

     public static void main(String[] args){
          new Launcher();
     }
}
