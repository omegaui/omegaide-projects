package omega.flexui;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.UIManager;
import java.awt.GraphicsEnvironment;
import java.awt.Font;
import java.awt.Color;
public class ResourceManager {
	public static Color background = new Color(255, 255, 255);
	public static Color alpha = new Color(0, 0, 0, 0);
	public static Color accent = new Color(60, 60, 200);
	public static Color progressColor = new Color(220, 20, 20);
	public static Color pointerColor = background;
	public static Color shade = new Color(220, 220, 220, 150);
	public static Color buttonTextColor = new Color(20, 20, 220);
	public static Color buttonShadeColor = new Color(20, 20, 220, 30);

     public static BufferedImage consoleImage = getImage("icons8-console-50.png");
    
	static{
		try{
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, ResourceManager.class.getResourceAsStream("/UbuntuMono-Bold.ttf")));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//Fonts
	public static final Font PX12 = new Font("Ubuntu Mono", Font.BOLD, 12);
	public static final Font PX14 = new Font("Ubuntu Mono", Font.BOLD, 14);
	public static final Font PX16 = new Font("Ubuntu Mono", Font.BOLD, 16);
	public static final Font PX18 = new Font("Ubuntu Mono", Font.BOLD, 18);
	public static final Font PX20 = new Font("Ubuntu Mono", Font.BOLD, 20);
	public static final Font PX22 = new Font("Ubuntu Mono", Font.BOLD, 22);
	public static final Font PX26 = new Font("Ubuntu Mono", Font.BOLD, 26);
	public static final Font PX28 = new Font("Ubuntu Mono", Font.BOLD, 28);
	public static final Font PX40 = new Font("Ubuntu Mono", Font.BOLD, 40);

     public static BufferedImage getImage(String name){
     	try{
     		return ImageIO.read(ResourceManager.class.getResourceAsStream("/" + name));
     	}
     	catch(Exception e){ 
     	     e.printStackTrace();
	     }
          return null;
     }
}
