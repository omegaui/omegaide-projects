package omega.plugin;
import java.awt.*;
import omega.comp.*;
import java.awt.image.*;
import javax.swing.*;

import static omega.utils.UIManager.*;
public class PluginComp extends JComponent{
     private BufferedImage image;
     private PlugInfo plugInfo;

     private TextComp imageComp;
     private TextComp nameComp;
     private TextComp versionComp;
     private TextComp sizeComp;
     private TextComp authorComp;
     private TextComp installComp;
     private TextComp enableComp;

     private boolean inStore;
     
     public PluginComp(BufferedImage image, PlugInfo plugInfo, boolean inStore){
     	this.image = image;
          this.plugInfo = plugInfo;
          this.inStore = inStore;
          init();
     }

     public void init(){
     	setLayout(null);

          imageComp = new TextComp("", TOOLMENU_COLOR1_SHADE, c2, TOOLMENU_COLOR1, null){
               @Override
               public void draw(Graphics2D g){
               	if(image != null){
                         g.setColor(color2);
                         g.fillRoundRect(18, 18, 64, 64, 40, 40);
                         g.drawImage(image, 18, 18, 64, 64, null);
               	}
               }
          };
          imageComp.setClickable(false);
          imageComp.setBounds(0, 0, 100, 100);
          add(imageComp);

          nameComp = new TextComp(plugInfo.name, plugInfo.desc, TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, null);
          nameComp.setBounds(110, 10, 200, 30);
          nameComp.setFont(PX14);
          nameComp.setClickable(false);
          add(nameComp);

          versionComp = new TextComp(plugInfo.version, TOOLMENU_COLOR2_SHADE, c2, TOOLMENU_COLOR2, null);
          versionComp.setBounds(320, 10, 50, 30);
          versionComp.setFont(PX14);
          versionComp.setClickable(false);
          add(versionComp);

          sizeComp = new TextComp(plugInfo.size, TOOLMENU_COLOR2_SHADE, c2, TOOLMENU_COLOR2, null);
          sizeComp.setBounds(380, 10, 80, 30);
          sizeComp.setFont(PX14);
          sizeComp.setClickable(false);
          add(sizeComp);

          authorComp = new TextComp("Author : " + plugInfo.author, plugInfo.copyright, TOOLMENU_COLOR4_SHADE, c2, TOOLMENU_COLOR4, null);
          authorComp.setBounds(110, 50, 150, 30);
          authorComp.setFont(PX14);
          authorComp.setClickable(false);
          add(authorComp);

          installComp = new TextComp(inStore ? "Install" : "Uninstall", TOOLMENU_COLOR1_SHADE, c2, TOOLMENU_COLOR1, null);
          installComp.setBounds(780 - 110, 100/2 - 15, 100, 30);
          installComp.setFont(PX14);
          add(installComp);

          enableComp = new TextComp("Enable", TOOLMENU_COLOR1_SHADE, c2, TOOLMENU_COLOR1, null);
          enableComp.setBounds(780 - 220, 100/2 - 15, 100, 30);
          enableComp.setFont(PX14);
          enableComp.setVisible(!inStore);
          add(enableComp);
     }
}
