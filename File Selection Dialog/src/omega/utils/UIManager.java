package omega.utils;
import com.formdev.flatlaf.*;
import java.awt.*;
public class UIManager {
	
	public static Color c1 = Color.decode("#563F2E");
	public static Color c2 = Color.decode("#0A0A28");
	public static Color c3 = Color.decode("#ABB0BC");
	public static Color TOOLMENU_COLOR1 = Color.decode("#f0b40f");
	public static Color TOOLMENU_COLOR1_SHADE = new Color(26, 36, 219, 40);
	public static Color TOOLMENU_COLOR2 = Color.decode("#D34D42");
	public static Color TOOLMENU_COLOR2_SHADE = new Color(223, 33, 15, 40);
	public static Color TOOLMENU_COLOR3 = Color.decode("#22d5d5");
	public static Color TOOLMENU_COLOR3_SHADE = new Color(126, 20, 219, 40);
	public static Color TOOLMENU_COLOR4 = Color.decode("#EB7201");
	public static Color TOOLMENU_COLOR4_SHADE = new Color(255, 158, 14, 40);
	static{
		try{
               FlatLightLaf.install();
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, UIManager.class.getResourceAsStream("/UbuntuMono-Bold.ttf")));
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, UIManager.class.getResourceAsStream("/Ubuntu-Bold.ttf")));
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	
	public static final Font PX12 = new Font("Ubuntu Mono", Font.BOLD, 12);
	public static final Font PX14 = new Font("Ubuntu Mono", Font.BOLD, 14);
	public static final Font PX16 = new Font("Ubuntu Mono", Font.BOLD, 16);
	public static final Font PX18 = new Font("Ubuntu Mono", Font.BOLD, 18);
	public static final Font PX20 = new Font("Ubuntu Mono", Font.BOLD, 20);
	public static final Font PX22 = new Font("Ubuntu Mono", Font.BOLD, 22);
	public static final Font PX26 = new Font("Ubuntu Mono", Font.BOLD, 26);
	public static final Font PX28 = new Font("Ubuntu Mono", Font.BOLD, 28);
	public static final Font PX40 = new Font("Ubuntu Mono", Font.BOLD, 40);
}
