package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class Config {
    private static final String PROPERTY_FILE = "%s.properties";
    public static final String DRIVER = "driver";
    private static Properties config;
    protected static String DEFAULT_CONFIG_NAME = "browser";
    private static Logger logger = Logger.getLogger("WD:");

    private static Properties loadProperties(String fileName)  {
        Properties result = new Properties();
        InputStream in = Config.class.getClassLoader().getResourceAsStream(fileName);
        try{
            result.load(in);
        }
        catch (IOException e){
            logger.info("Can't read property file");
        }
        return result;
    }

    public static String getProperty(String key) {
        try {
            if (config == null) {
                String fileName = String.format(PROPERTY_FILE, DEFAULT_CONFIG_NAME);
                config = loadProperties(fileName);
            }
            if (config.containsKey(key)) {
                return config.getProperty(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
