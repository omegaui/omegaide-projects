package omega.flexui;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Color;
import static omega.flexui.ResourceManager.*;
public class FlexSwitch extends FlexComponent{
     private boolean enabled;
     private ToggleListener toggleListener;
     public FlexSwitch(boolean enabled, ToggleListener toggleListener){
          super(background, progressColor);
          this.enabled = enabled;
          this.toggleListener = toggleListener;
          setBackground(background);
          addMouseListener(new MouseAdapter(){
               @Override
               public void mousePressed(MouseEvent e){
                   FlexSwitch.this.enabled = !FlexSwitch.this.enabled;
                   repaint();
                   if(FlexSwitch.this.toggleListener != null)
                         FlexSwitch.this.toggleListener.toggle(FlexSwitch.this.enabled);
               }
          });
     }

     @Override
     public void draw(Graphics2D g){
     	if(enabled){
               g.setColor(progressColor);
               g.fillRoundRect(0, 0, getWidth(), getHeight(), arcX, arcY);
               g.setColor(pointerColor);
               g.fillOval(3, 3, getHeight() - 6, getHeight() - 6);
               g.setColor(progressColor);
               g.fillOval(3 + (getHeight() - 6)/2 - (getHeight() - 6)/8, 
                          3 + (getHeight() - 6)/2 - (getHeight() - 6)/8, 
                          (getHeight() - 6)/4, (getHeight() - 6)/4);
     	}
          else {
               g.setColor(progressColor);
               g.fillRoundRect(0, 0, getWidth(), getHeight(), arcX, arcY);
               g.setColor(pointerColor);
               g.fillOval(getWidth() - getHeight() - 1, 3, getHeight() - 6, getHeight() - 6);
          }
     }
}
