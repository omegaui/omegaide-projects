package omega.plugin;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.event.*;
import omega.comp.*;
import java.awt.*;
import javax.swing.*;
import static omega.utils.UIManager.*;
public class PluginCenter extends JFrame{
	private int pressX;
	private int pressY;
	private TextComp titleComp;
	private TextComp closeComp;
	private TextComp updateComp;
	private TextComp manageComp;
	private TextComp sep0;
	private TextComp storeComp;
     private NoCaretField searchField;
	private JPanel mainPanel;
	private JPanel managePanel;
     private Updater updater;
	
	public PluginCenter(){
		super("Plugin Center");
		setUndecorated(true);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(c2);
		JPanel panel = new JPanel(null);
		panel.setBackground(getBackground());
		setContentPane(panel);
		init();
		setVisible(true);
	}
	public void init(){
          updater = new Updater(this);
          
		titleComp = new TextComp("Plugin Center", TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, null);
		titleComp.setBounds(0, 0, getWidth() - 30, 30);
		titleComp.setFont(PX16);
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
			public void mouseDragged(MouseEvent e) {
				setLocation(e.getXOnScreen() - pressX, e.getYOnScreen() - pressY);
			}
		});
		titleComp.setArc(0, 0);
		add(titleComp);
          
		closeComp = new TextComp("x", TOOLMENU_COLOR2_SHADE, c2, TOOLMENU_COLOR2, this::dispose);
		closeComp.setBounds(getWidth() - 30, 0, 30, 30);
		closeComp.setFont(PX14);
		closeComp.setArc(0, 0);
		add(closeComp);
          
		updateComp = new TextComp("Update IDE", "Check for IDE Updates", TOOLMENU_COLOR4_SHADE, TOOLMENU_COLOR4, c2, ()->updater.setVisible(true));
		updateComp.setBounds(getWidth() - 100, 40, 90, 25);
          updateComp.setFont(PX14);
		add(updateComp);
         
		manageComp = new TextComp("Manage", "Manage Installed Plugins", TOOLMENU_COLOR1_SHADE, c2, TOOLMENU_COLOR1, null);
		manageComp.setBounds(getWidth()/2 - 110, 40, 100, 35);
		manageComp.setFont(PX16);
		add(manageComp);
         
		sep0 = new TextComp("", TOOLMENU_COLOR3, TOOLMENU_COLOR3, TOOLMENU_COLOR3, null);
		sep0.setBounds(getWidth()/2, 40, 2, 40);
		add(sep0);
		
		storeComp = new TextComp("Store", "See Available Plugins", TOOLMENU_COLOR1_SHADE, c2, TOOLMENU_COLOR1, null);
		storeComp.setBounds(getWidth()/2 + 10, 40, 100, 35);
		storeComp.setFont(PX16);
		add(storeComp);

          searchField = new NoCaretField("", "search plugins here", TOOLMENU_COLOR2, c2, TOOLMENU_COLOR3);
          searchField.setBounds(getWidth()/2 - 200, 100, 400, 30);
          searchField.setFont(PX16);
          add(searchField);
          addKeyListener(searchField);
          
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(TOOLMENU_COLOR4);
		mainPanel.setBounds(10, 150, getWidth() - 20, getHeight() - 110);
		add(mainPanel);
          
		managePanel = new JPanel(null);
		managePanel.setBackground(c2);
		mainPanel.add(managePanel, BorderLayout.CENTER);
       
		BufferedImage image = null;
		BufferedImage gitImage = null;
		
		try{
			image = ImageIO.read(getClass().getResourceAsStream("/omega_ide_icon64.png"));
			gitImage = ImageIO.read(getClass().getResourceAsStream("/Octocat.png"));
		}
		catch(Exception e){
			System.err.println(e);
		}
          
		PluginComp pluginComp = new PluginComp(image, new PlugInfo("Jar Builder", "1.8", "sample.jar", "omegaui", "correct", "100.1 KB", "Its a sample plugin info!"), false);
		pluginComp.setBounds(0, 0, mainPanel.getWidth(), 100);
		managePanel.add(pluginComp);
          
		PluginComp pluginComp1 = new PluginComp(gitImage, new PlugInfo("Git Integration", "1.8", "sample.jar", "omegaui", "correct", "3.10 MB", "Its a sample plugin info!"), false);
		pluginComp1.setBounds(0, 105, mainPanel.getWidth(), 100);
		managePanel.add(pluginComp1);
	}
	public void notify(String msg){
		titleComp.setText(msg);
	}
	public static void main(String[] args){
		new PluginCenter();
	}
}
