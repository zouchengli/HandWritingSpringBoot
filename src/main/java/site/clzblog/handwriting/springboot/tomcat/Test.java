package site.clzblog.handwriting.springboot.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import site.clzblog.handwriting.springboot.servlet.IndexServlet;

/**
 * Test java manually create tomcat server
 */
public class Test {

    private static int PORT = 8080;
    private static String CONTEXT_PATH = "/clzblog";

    public static void main(String[] args) throws LifecycleException {

        // Create tomcat server
        Tomcat tomcat = new Tomcat();

        // Setting tomcat port number
        tomcat.setPort(PORT);
        tomcat.getHost().setAutoDeploy(false);

        // Create standard context
        StandardContext standardContext = new StandardContext();
        standardContext.setPath(CONTEXT_PATH);
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());

        // Tomcat container add standard context
        tomcat.getHost().addChild(standardContext);
        tomcat.addServlet(CONTEXT_PATH, "IndexServlet", new IndexServlet());

        // Add servlet url mapping
        standardContext.addServletMappingDecoded("/index", "IndexServlet");

        tomcat.start();

        System.out.println("Tomcat start successfully");

        tomcat.getServer().await();

    }
}
