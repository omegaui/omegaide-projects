package omega.plugin;
import java.net.*;
import java.io.*;
public class PluginInfoManager {
	public static void write(){
		File dir = new File("/home/arham/omega-ide-plugins");
		File[] files = dir.listFiles((file)->file.getName().endsWith("-OMEGAIDE.jar"));
          System.out.println("Total Plugins : " + files.length);
          try {
     		PrintWriter writer = new PrintWriter(new File(".plugInfos"));
     		for(File file : files){
     			String fileName = file.getName();
     			String className = fileName.substring(fileName.indexOf('-') + 1, fileName.lastIndexOf('-'));
          		URLClassLoader loader = URLClassLoader.newInstance(new URL[] { file.toURL() } );
     			Plugin plugin = (Plugin)loader.loadClass(className).newInstance();
     			writer.println("---------> Plugin Info Starts");
     			writer.println(fileName);
     			writer.println(plugin.getName());
     			writer.println(plugin.getVersion());
     			writer.println(plugin.getAuthor());
     			writer.println(plugin.getCopyright());
     			writer.println(plugin.getSize());
     			writer.println(plugin.getDescription());
     			writer.println("---------> Plugin Info Ends");
     			writer.flush();
     			loader.close();
     		}
               writer.close();
          }
          catch(Exception e){
               e.printStackTrace();
          }
	}
     
     public static void main(String[] args){
     	write();
     }
}
