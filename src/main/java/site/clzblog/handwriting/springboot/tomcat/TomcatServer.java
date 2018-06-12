package site.clzblog.handwriting.springboot.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

/**
 * @Desc Tomcat server
 * @Author chengli.zou
 * @CreateDate 6/12/18
 */
public class TomcatServer {

    public static void main(String[] args) {
        try {
            start();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

    public static void start() throws ServletException, LifecycleException {
        // Create tomcat server
        Tomcat tomcatServer = new Tomcat();

        // Port number setting
        tomcatServer.setPort(9999);

        // Read project path
        StandardContext context = (StandardContext) tomcatServer.addWebapp("/", new File("src/main").getAbsolutePath());

        // Disable reload
        context.setReloadable(false);

        // Class file read address
        File webInfoClasses = new File("target/classes");

        // Create web root
        WebResourceRoot webResourceRoot = new StandardRoot(context);

        // Tomcat read inner class execute
        webResourceRoot.addPreResources(new DirResourceSet(webResourceRoot, "/WEB-INF/classes", webInfoClasses.getAbsolutePath(), "/"));

        // Server start
        tomcatServer.start();

        // Asynchronous wait request execute
        tomcatServer.getServer().await();
    }

}
