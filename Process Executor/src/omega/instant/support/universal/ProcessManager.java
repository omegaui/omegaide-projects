package omega.instant.support.universal;
import java.io.File;
import java.util.LinkedList;
import omega.database.DataBase;
public class ProcessManager extends DataBase{
     public static LinkedList<ProcessData> dataSet = new LinkedList<>();
     public ProcessManager(){
     	super(".processExecutionData");
          load();
     }

     public void load(){
     	getDataSetNames().forEach(set->{
               dataSet.add(new ProcessData(set, getEntryAt(set, 0).getValue()));
	     });
     }

     @Override
     public void save(){
     	clear();
          dataSet.forEach(data->{
               addEntry(data.fileExt, data.executionCommand);
          });
          super.save();
     }

     public void add(String ext, String cmd){
     	dataSet.add(new ProcessData(ext, cmd));
     }

     public synchronized void launch(File file){
     	try{
     		
     	}
     	catch(Exception e){ 
     		e.printStackTrace();
     	}
     }
}
