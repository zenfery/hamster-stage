package cc.zenfery.hamster.ctrl.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 基础包controller
 * 
 * @author pengfei 2015年9月8日
 * @since JDK 1.7
 */
@Controller
public class CommonController {

    /**
     * <pre>
     * localeChange: 转换语言
     * </pre>
     * 
     * @author: pengfei 2015年8月11日
     * @param lang
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/locale", method = RequestMethod.POST)
    public String localeChange(@RequestParam("locale") String locale) {
        return locale;
    }
}
