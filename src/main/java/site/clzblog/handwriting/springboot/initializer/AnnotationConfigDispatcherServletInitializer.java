package site.clzblog.handwriting.springboot.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import site.clzblog.handwriting.springboot.configuration.RootConfiguration;
import site.clzblog.handwriting.springboot.configuration.WebConfiguration;

/**
 * @Desc Load SpringMVC dispatcher servlet
 * @Author chengli.zou
 * @CreateDate 6/12/18
 */
public class AnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * Load root container
     *
     * @return
     */
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfiguration.class};
    }

    /**
     * Load SpringMVC container
     *
     * @return
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfiguration.class};
    }

    /**
     * SpringMVC dispatcher servlet intercepted request
     *
     * @return
     */
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
