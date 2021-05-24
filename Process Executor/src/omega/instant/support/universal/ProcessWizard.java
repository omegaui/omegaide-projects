package omega.instant.support.universal;
import omega.utils.*;
import java.awt.*;
import java.util.*;
import omega.comp.*;
import javax.swing.*;
import static omega.utils.UIManager.*;
public class ProcessWizard extends JFrame{
     private TextComp titleComp;
     private NoCaretField extField;
     private NoCaretField cmdField;
     private LinkedList<TextComp> items = new LinkedList<>();
     private FlexPanel containerPanel;
     private JScrollPane scrollPane;
     private JPanel contentPanel;
     private int block;
     public ProcessWizard(){
     	super("Process Wizard");
          setUndecorated(true);
          setSize(400, 500);
          setLocationRelativeTo(null);
          JPanel panel = new JPanel(null);
          panel.setBackground(c2);
          setContentPane(panel);
          setBackground(c2);
          setLayout(null);
          init();
          setVisible(true);
     }

     public void init(){
     	titleComp = new TextComp("Process Wizard", TOOLMENU_COLOR3, c2, c2, null);
          titleComp.setBounds(0, 0, getWidth(), 30);
          titleComp.setFont(PX14);
          titleComp.setArc(0, 0);
          titleComp.setClickable(false);
          titleComp.attachDragger(this);
          add(titleComp);

          TextComp label1 = new TextComp("File Extension", TOOLMENU_COLOR1_SHADE, c2, TOOLMENU_COLOR1, null);
          label1.setBounds(10, 50, 150, 25);
          label1.setFont(PX14);
          label1.setClickable(false);
          add(label1);

          extField = new NoCaretField("", "Click Me", TOOLMENU_COLOR3, c2, TOOLMENU_COLOR2);
          extField.setBounds(170, 50, getWidth() - 190, 25);
          extField.setFont(PX14);
          add(extField);

          TextComp label2 = new TextComp("Execution Command", TOOLMENU_COLOR1_SHADE, c2, TOOLMENU_COLOR1, null);
          label2.setBounds(10, 100, 150, 25);
          label2.setFont(PX14);
          label2.setClickable(false);
          add(label2);

          cmdField = new NoCaretField("", "Click Me", TOOLMENU_COLOR3, c2, TOOLMENU_COLOR2);
          cmdField.setBounds(170, 100, getWidth() - 190, 25);
          cmdField.setFont(PX14);
          add(cmdField);

          TextComp addComp = new TextComp("Add/Update", TOOLMENU_COLOR2_SHADE, c2, TOOLMENU_COLOR2, this::addCurrent);
          addComp.setBounds(getWidth()/2 - 75, 150, 150, 25);
          addComp.setFont(PX14);
          add(addComp);

          containerPanel = new FlexPanel(null, TOOLMENU_COLOR1_SHADE, TOOLMENU_COLOR1);
          containerPanel.setBounds(10, 200, getWidth() - 20, 300);
          containerPanel.setPaintGradientEnabled(true);
          containerPanel.setArc(10, 10);
          add(containerPanel);

          scrollPane = new JScrollPane(contentPanel = new JPanel(null));
          scrollPane.setBounds(10, 10, containerPanel.getWidth() - 20, containerPanel.getHeight() - 20);
          scrollPane.setBackground(c2);
          containerPanel.add(scrollPane);
          contentPanel.setBackground(c2);
          contentPanel.setSize(scrollPane.getWidth(), 300);
     }

     public void genView(){
     	items.forEach(contentPanel::remove);
          items.clear();

          block = 0;
          ProcessManager.dataSet.forEach(data->{
               TextComp comp = new TextComp(data.fileExt, data.executionCommand, TOOLMENU_COLOR3_SHADE, c2, TOOLMENU_COLOR3, ()->setToView(data));
               comp.setBounds(0, block, contentPanel.getWidth(), 25);
               comp.setFont(PX14);
               comp.setArc(0, 0);
               contentPanel.add(comp);
               items.add(comp);
               block += 25;

               TextComp remComp = new TextComp(IconManager.fluentcloseImage, 25, 25, "Delete this Process Data", TOOLMENU_COLOR2_SHADE, c2, TOOLMENU_COLOR2, ()->removeData(data));
               remComp.setBounds(contentPanel.getWidth() - 25, 0, 25, 25);
               comp.add(remComp);
          });

          contentPanel.setPreferredSize(new Dimension(scrollPane.getWidth(), block));
          repaint();
     }

     public void removeData(ProcessData data){
     	ProcessManager.dataSet.remove(data);
          int pointer = scrollPane.getVerticalScrollBar().getValue();
          genView();
          scrollPane.getVerticalScrollBar().setValue(pointer - 25);
     }

     public void setToView(ProcessData data){
     	extField.setText(data.fileExt);
          cmdField.setText(data.executionCommand);
     }

     public void addCurrent(){
     	String ext = extField.getText();
          titleComp.setColors(TOOLMENU_COLOR2, c2, c2);
          if(ext.equals("")){
               titleComp.setText("Enter a file extension");
               return;
          }
          String cmd = cmdField.getText();
          if(cmd.equals("")){
               titleComp.setText("Enter the execution command for " + ext + " files");
               return;
          }
          titleComp.setColors(TOOLMENU_COLOR3, c2, c2);
          titleComp.setText("Process Wizard");

          //Atempting to add the current data
          boolean done = false;
          for(ProcessData data : ProcessManager.dataSet){
               if(data.fileExt.equals(ext)) {
                    data.executionCommand = cmd;
                    done = true;
                    break;
               }
          }
          if(!done){
               ProcessManager.dataSet.add(new ProcessData(ext, cmd));
          }
          int pointer = scrollPane.getVerticalScrollBar().getValue() + (done ? 0 : 25);
          genView();
          scrollPane.getVerticalScrollBar().setValue(pointer);
     }

     @Override
     public void setVisible(boolean value){
     	if(value){
               genView();
               if(items.isEmpty())
                    setSize(400, 200);
               else
                    setSize(400, 500);
               setLocationRelativeTo(null);
     	}
          super.setVisible(value);
     }
}
