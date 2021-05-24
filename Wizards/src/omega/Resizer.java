package omega;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class Resizer {
     public static void main(String[] args){
     	String filePath = "/IMG_20191013_200405-01.jpg";
          try{
          	BufferedImage image = ImageIO.read(Resizer.class.getResourceAsStream(filePath));
               BufferedImage res = new BufferedImage(250, 250, BufferedImage.TYPE_INT_ARGB);
               Graphics g = res.getGraphics();
               g.drawImage(image, 0, 0, 250, 250, null);
               g.dispose();
               ImageIO.write(image, "JPG", new File("photo.jpg"));
          }
          catch(Exception e){ 
          	System.err.println(e);
          }
     }
}
