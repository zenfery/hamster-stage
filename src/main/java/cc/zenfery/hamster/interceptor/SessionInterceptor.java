package cc.zenfery.hamster.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * <pre>
 * Session验证拦截器
 * </pre>
 * 
 * @author pengfei.cheng 2015年5月18日
 * @since JDK 1.7
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {

    private String loginUrl;

    private Log logger = LogFactory.getLog(this.getClass());

    /**
     * TODO 校验用户登录状态
     * 
     * @author pengfei.cheng 2015年5月18日
     * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("System login url is : " + loginUrl);
        return true;
    }

    /**
     * @return the loginUrl
     */
    public String getLoginUrl() {
        return loginUrl;
    }

    /**
     * @param loginUrl
     *            the loginUrl to set
     */
    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

}
