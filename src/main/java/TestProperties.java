import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private final Properties properties = new Properties();

    private static TestProperties INSTANCE = null;

    private TestProperties() {
//        System.setProperty("environment", "application");
        try {
            ClassLoader classLoader = TestProperties.class.getClassLoader();
            properties.load(classLoader.getResourceAsStream("environment.properties"));
            //properties.load(new FileInputStream(new File("environment.properties" + System.getProperty("environment") + ".properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestProperties getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }
}