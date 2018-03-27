package cc.zenfery.hamster.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * sprint context支持类
 * 
 * @author 鹏飞 2015年7月13日
 * @since JDK 1.7
 */
public class SpringContextSupport extends HttpServlet {

    private static Log logger = LogFactory.getLog(SpringContextSupport.class);
    // spring容器
    private static WebApplicationContext context = null;

    private static ServletContext servletContext = null;

    /**
     * 初始化方法
     * 
     * @author 鹏飞 2015年7月13日
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     */
    @Override
    public void init() throws ServletException {
        if (servletContext == null)
            servletContext = this.getServletContext();
        getContext();
    }

    /**
     * <pre>
     * getContext: 获取sprint ioc 容器
     * </pre>
     * 
     * @author: 鹏飞 2015年7月13日
     * @return WebApplicationContext
     */
    public static WebApplicationContext getContext() {
        if (servletContext == null) {
            logger.warn(" getContext(): Servlet Context is not supported, it may not be an J2EE environment!!!");
        } else if (context == null) {
            logger.info(" getContext(): Currently, Sprint Context is null, init it by WebApplicationContextUtils.getRequiredWebApplicationContext().");
            context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        }
        return context;
    }

}
