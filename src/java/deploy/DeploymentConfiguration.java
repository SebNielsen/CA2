package deploy;
import java.util.Map;
import javax.servlet.ServletContextEvent;

/**
 * @author Tobias Jacobsen
 */
public class DeploymentConfiguration {

    public static String PU_NAME = "pu_dev";

    public void contextInitialized(ServletContextEvent sce) {
        Map<String, String> env = System.getenv();
        if (env.keySet().contains("OPENSHIFT_MYSQL_DB_HOST")) {
            PU_NAME = "pu_openshift";
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
    
    public static void setTestModeOn() {
        PU_NAME = "pu_test";
    }
    
    public static void setDevModeOn() {
        PU_NAME = "pu_dev";
    }
}

