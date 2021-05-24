package omega.flexui;
import java.awt.Graphics2D;
import java.awt.Component;
import java.awt.Color;
import static omega.flexui.ResourceManager.*;
public class FlexContainer extends FlexComponent{
     public int block = 0;
     public int separation = 0;
     public int startOffset = 0;
     public FlexContainer(int startOffset, int separation){
     	super(shade, null);
          this.separation = separation;
          this.startOffset = startOffset;
     }

     public void putNext(Component c){
     	c.setLocation(startOffset + block + separation, 10);
          block += c.getWidth() + separation;
          add(c);
     }
}
