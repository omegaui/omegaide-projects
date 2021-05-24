package omega.flexui;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import static omega.flexui.ResourceManager.*;
public class FlexButton extends FlexComponent{
	public String text;
	public int alignX = -1;
	public boolean enter = false;
     public BufferedImage image;
	
	public FlexButton(String text){
		super(background, null);
		this.text = text;
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				enter = true;
				repaint();
			}
			@Override
			public void mouseExited(MouseEvent e){
				enter = false;
				repaint();
			}
			@Override
			public void mousePressed(MouseEvent e){
				enter = false;
				repaint();
			}
		});
	}
	
	public FlexButton(BufferedImage image){
		this("");
          this.image = image;
	}
	@Override
	public void draw(Graphics2D g){
		if(enter){
			g.setColor(buttonShadeColor);
			g.fillRoundRect(0, 0, getWidth(), getHeight(), arcX, arcY);
		}
          if(image != null) {
               g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
          }
          else if(text != null){
     		g.setColor(buttonTextColor);
     		g.setFont(getFont());
     		if(alignX < 0){
     			g.drawString(text, getWidth()/2 - g.getFontMetrics().stringWidth(text)/2, getHeight()/2 - g.getFontMetrics().getHeight()/2 + g.getFontMetrics().getAscent() - g.getFontMetrics().getDescent() + 1);
     			if(enter)
     				g.fillRect(getWidth()/2 - g.getFontMetrics().stringWidth(text)/2, getHeight() - 4, g.getFontMetrics().stringWidth(text), 2);
     		}
     		else{
     			g.drawString(text, alignX, getHeight()/2 - g.getFontMetrics().getHeight()/2 + g.getFontMetrics().getAscent() - g.getFontMetrics().getDescent() + 1);
     			if(enter)
     				g.fillRect(alignX, getHeight() - 4, g.getFontMetrics().stringWidth(text), 2);
     		}
          }
	}
}
