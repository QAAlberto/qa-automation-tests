package pages;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    public FileReader fileReader;
    public Properties properties;

    public String getProperty(String key, String project) {
        try {
            fileReader = new FileReader("src/main/java/pages/"+project+"/"+project+".properties");
            properties = new Properties();
            properties.load(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
