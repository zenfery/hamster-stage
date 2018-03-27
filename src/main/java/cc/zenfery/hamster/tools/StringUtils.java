package cc.zenfery.hamster.tools;

import java.util.Iterator;
import java.util.Map;

/**
 * 常用的字符串操作
 * 
 * @author 鹏飞 2015年7月14日
 * @since JDK 1.7
 */
public abstract class StringUtils {

    /**
     * <pre>
     * placeholderResolver: 使用占位符替换字符串参数，占位符，如{0}, {1}
     * </pre>
     * 
     * @author: 鹏飞 2015年7月14日
     * @param original
     *            原始字符串
     * @param values
     *            替换参数
     * @return
     */
    public static String placeholderResolver(String original, Object... values) {
        if (original == null) {
            return null;
        }
        if (values == null || values.length == 0) {
            return original;
        }
        for (int i = 0; i < values.length; i++) {
            original = original.replaceAll("\\{" + i + "\\}", (String) values[i]);
        }
        return original;
    }

    /**
     * 使用名称来替换占位符
     * 
     * @param original
     * @param params
     *            参数键值对
     * @return
     */
    public static String placeholderResolver(String original, Map<String, String> params) {
        if (original == null) {
            return null;
        }
        if (params == null || params.size() == 0) {
            return original;
        }
        Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            original = original.replaceAll("\\{" + entry.getKey() + "\\}", entry.getValue());
        }
        return original;
    }

    /**
     * 泛域名匹配
     * 
     * @author zhanghui
     * @param source
     * @param target
     * @return
     */
    public static boolean panDomainMatch(String source, String target) {
        if (!org.apache.commons.lang.StringUtils.contains(target, "*")) {
            return false;
        }

        String panDomainEl = "^" + org.apache.commons.lang.StringUtils.substringBefore(target, "//") + "//.*"
                + org.apache.commons.lang.StringUtils.substringAfter(target, "*").replace(".", "\\.") + "$";
        return source.matches(panDomainEl);
    }

}
