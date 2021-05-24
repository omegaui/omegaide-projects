package omega.deassembler;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JFrame;
import java.util.zip.*;
import java.util.jar.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.reflect.*;
public class JarLoader {
	public String jarPath;
	public LinkedList<ByteReader> readers = new LinkedList<>();
	public LinkedList<String> classNames = new LinkedList<>();
	public URLClassLoader loader;
	public JarLoader(String jarPath){
		this.jarPath = jarPath;
		load();
	}
	private void load(){
		try{
			File file = new File(jarPath);
			if(!file.exists())
				return;
			loadClassNames();
			loader = URLClassLoader.newInstance(new URL[]{
				file.toURL()
			});
			classNames.forEach(name->{
				try{
					ByteReader br = new ByteReader(loader.loadClass(name));
					readers.add(br);
				}
				catch(Exception e){
					System.err.println(e);
				}
			});
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	
	private void loadClassNames(){
		readJar();
	}
	
	public void readJar(){
		try{
			try(JarFile rtJarFile = new JarFile(jarPath)){
				for(Enumeration<JarEntry> enums = rtJarFile.entries(); enums.hasMoreElements();){
					JarEntry jarEntry = enums.nextElement();
					String name = jarEntry.getName();
					if(!name.endsWith("/")) {
						String classPath = convertJarPathToPackagePath(name);
						if(classPath != null) {
							classNames.add(classPath);
						}
					}
				}
			}
		}
		catch(Exception e) {
			System.err.println(e);
		}
	}
	public static String convertJarPathToPackagePath(String zipPath){
		if(zipPath == null || zipPath.contains("$") || !zipPath.endsWith(".class") || zipPath.startsWith("META-INF"))
			return null;
		zipPath = zipPath.substring(0, zipPath.lastIndexOf('.'));
		StringTokenizer tok = new StringTokenizer(zipPath, "/");
		zipPath = "";
		while(tok.hasMoreTokens())
			zipPath += tok.nextToken() + ".";
		zipPath = zipPath.substring(0, zipPath.length() - 1);
		return zipPath.equals("module-info") ? null : zipPath;
	}
	public ByteReader getReader(String className){
		for(ByteReader br : readers){
			if(br.className.equals(className))
				return br;
		}
		return null;
	}
	public Class loadClass(String className){
		try{
			return loader.loadClass(className);
		}
		catch(Exception e){
			System.err.println(e);
		}
		return null;
	}
	public void close(){
		try{
			loader.close();
			readers.forEach(r->r.close());
			readers.clear();
			classNames.clear();
		}
		catch(Exception e){
			System.err.println(e);
		}
	}
	public static synchronized JarLoader prepareModule(String modulePath){
		try{
			ZipFile moduleFile = new ZipFile(modulePath);
			ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("readable-module-data.jar"));
			for(Enumeration enums = moduleFile.entries(); enums.hasMoreElements();){
				ZipEntry entry = (ZipEntry)enums.nextElement();
				String name = entry.getName();
				if((name.startsWith("classes") && !name.contains("module-info")) || name.startsWith("resources")){
                         zipOutputStream.putNextEntry(new ZipEntry(name.substring(name.indexOf('/') + 1)));
                         InputStream in = moduleFile.getInputStream(entry);
                         while(in.available() > 0)
                              zipOutputStream.write(in.read());
                         zipOutputStream.flush();
				}
			}
              zipOutputStream.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new JarLoader("readable-module-data.jar");
	}
	public static void main(String[] args){
		//JarLoader loader = prepareModule("/home/ubuntu/Documents/Omega IDE/lib/openjfx-11.0.2_linux-x64_bin-jmods/javafx-jmods-11.0.2/javafx.base.jmod");
		//System.out.println(loader.getReader("javafx.util.Builder"));
          try{
          	Class c = JarLoader.class.getClassLoader().loadClass("jdk.internal.misc.InnocuousThread");
               System.out.println(c);
          }
          catch(Exception e){ 
          	System.err.println(e); 
          }
	}
}
