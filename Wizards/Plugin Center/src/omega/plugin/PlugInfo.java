package omega.plugin;

public class PlugInfo {
     public String name;
     public String version;
     public String fileName;
     public String author;
     public String copyright;
     public String size;
     public String desc = "";

     public PlugInfo(){
          
     }

     public PlugInfo(String name, String version, String fileName, String author, String copyright, String size, String desc){
          this.name = name;
          this.fileName = fileName;
          this.size = size;
          this.desc = desc;
          this.version = version;
          this.author = author;
          this.copyright = copyright;
     }
}