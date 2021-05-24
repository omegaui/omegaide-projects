package omega

import java.awt.*
import java.awt.event.*
import javax.swing.*

class Splash extends JFrame{
     def ide_name = 'Omega IDE'
     def click = false
     Splash(){
          setUndecorated(true)
          def panel = new JPanel(null)
          panel.setBackground(Color.WHITE)
          setContentPane(panel)
          setBackground(Color.WHITE)
          setSize(400, 400)
          setLocationRelativeTo(null)
          setDefaultCloseOperation(EXIT_ON_CLOSE)
          addMouseListener(new MouseAdapter(){
               @Override
               void mousePressed(MouseEvent e) {
                    click = true
                    repaint()
               }
          })
          setVisible(true)
     }

     @Override
     void paint(Graphics g){
          super.paint(g)
          if(click) {
               for(it in 100..200) {
                    g.setColor(getRandomColor())
                    g.fillRect(it, it, 50, 50)
               }
          }
     }

     def getRandomColor(){
          new Color((int)Math.round(Math.random() * 255), (int)Math.round(Math.random() * 255), (int)Math.round(Math.random() * 255))
     }
}

def splash = new Splash()

