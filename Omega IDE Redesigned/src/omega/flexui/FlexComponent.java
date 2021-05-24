package omega.flexui;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.GradientPaint;
import java.awt.Color;
import javax.swing.JComponent;
import static omega.flexui.ResourceManager.*;
public class FlexComponent extends JComponent{
	public Color accent;
    
	public int arcX = 40;
	public int arcY = 40;
     public boolean paintGradientEnabled = false;
     public GradientPaint paint;
   
	public FlexComponent(Color background, Color accent){
		setBackground(background);
		setLayout(null);
          setFont(PX14);
		this.accent = accent;
	}
    
	public Color getAccent() {
		return accent;
	}
	
	public void setAccent(Color accent) {
		this.accent = accent;
	}

     public void setGradient(){
          paint = new GradientPaint(0, 0, getBackground(), getWidth(), getHeight(), accent == null ? getBackground() : accent);
     }

     public void setReverseGradient(){
          paint = new GradientPaint(0, 0, accent == null ? getBackground() : accent, getWidth(), getHeight(), getBackground());
     }
     
     public void setArc(int x, int y){
          arcX = x;
          arcY = y;
     }

     public void draw(Graphics2D g){
     	
     }
     
     @Override
     public void paint(Graphics graphics){
          if(paintGradientEnabled)
               setGradient();
          Graphics2D g = (Graphics2D)graphics;
          g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
          g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
          g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
          if(paintGradientEnabled)
               g.setPaint(paint);
          else
               g.setColor(getBackground());
          g.fillRoundRect(0, 0, getWidth(), getHeight(), arcX, arcY);
          draw(g);
          super.paint(g);
     }
}
