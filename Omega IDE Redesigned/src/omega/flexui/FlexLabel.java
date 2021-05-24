package omega.flexui;
import java.awt.event.MouseListener;
public class FlexLabel extends FlexButton{
     public FlexLabel(String text){
          super(text);
     	for(MouseListener listener : getMouseListeners())
               removeMouseListener(listener);
     }
}
