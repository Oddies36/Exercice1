package be.ex1.DAL.Initializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBProperties {
    
    private Properties properties;

    public DBProperties(String path){
        properties = new Properties();
        try(FileInputStream finput = new FileInputStream(path)){
            properties.load(finput);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public String getUrl(){
        return properties.getProperty("database.url");
    }
    public String getUsername(){
        return properties.getProperty("database.username");
    }
    public String getPassword(){
        return properties.getProperty("database.password");
    }
}
