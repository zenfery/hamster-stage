package cc.zenfery.hamster.common.i18n;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.support.RequestContextUtils;

import cc.zenfery.hamster.common.SpringContextSupport;

/**
 * 
 * 国际化支持：配置i18n/message*.properties
 * 
 * @author pengfei 2015年9月8日
 * @since JDK 1.7
 */
public class MessageConfig {

    /**
     * <pre>
     * getMessage:根据key获取当前message的信息
     * </pre>
     * 
     * @author: pengfei 2015年8月11日
     * @param key
     * @return message
     */
    public static String getMessage(String key) {
        return getMessage(key, null);
    }

    /**
     * <pre>
     * getMessage: 根据key获取当前message的信息
     * </pre>
     * 
     * @author: pengfei 2015年8月11日
     * @param key
     *            code
     * @param args
     *            占位参数
     * @return
     */
    public static String getMessage(String key, Object[] args) {
        return getMessage(key, args, null);
    }

    /**
     * <pre>
     * getMessage: 根据key获取当前message的信息
     * </pre>
     * 
     * @author: pengfei 2015年8月11日
     * @param key
     *            code
     * @param args
     *            占位参数
     * @param locale
     * @return
     */
    public static String getMessage(String key, Object[] args, Locale locale) {
        if (key == null) {
            return null;
        }
        WebApplicationContext wac = SpringContextSupport.getContext();
        if (wac == null) {
            return null;
        }
        if (locale == null) {
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = (HttpServletRequest) ra.resolveReference(RequestAttributes.REFERENCE_REQUEST);
            locale = RequestContextUtils.getLocale(request);
        }
        return wac.getMessage(key, args, locale);
    }
}
