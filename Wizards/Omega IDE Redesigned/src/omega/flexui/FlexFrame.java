package omega.flexui;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import static omega.flexui.ResourceManager.*;
public class FlexFrame extends JFrame{
	private JPanel contentPanel;
	
	public FlexFrame(String title){
		super(title);
		setUndecorated(true);
          FlexPanel panel = new FlexPanel(null, background, accent);
          panel.setArc(0, 0);
		setContentPane(panel);
		setBackground(background);
	}
	public void centerFrame(){
		setLocationRelativeTo(null);
	}
}
