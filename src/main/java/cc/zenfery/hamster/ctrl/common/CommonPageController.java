package cc.zenfery.hamster.ctrl.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * 通用的页面请求:
 *  若请求的模板页面无特殊业务配置，直接走此类配置的通用Controller，仅作为后端的一个转发，基础渲染
 * </pre>
 * 
 * @author pengfei 2015年10月23日
 * @since JDK 1.7
 */
@Controller
public class CommonPageController {

    /**
     * <pre>
     * page1: 一级目录请求处理，除去api请求
     * </pre>
     * 
     * @author: pengfei 2015年10月23日
     * @param path1
     *            一级目录
     * @return
     */
    @RequestMapping(value = "/{path1:^(?:(?!api)[a-z0-9_\\-])+$}")
    public String page1(@PathVariable String path1) {
        return path1;
    }

    /**
     * <pre>
     * page1: 二级目录请求处理，除去api请求
     * </pre>
     * 
     * @author: pengfei 2015年10月23日
     * @param path1
     *            一级目录
     * @return
     */
    @RequestMapping(value = "/{path1:^(?:(?!api)[a-z0-9_\\-])+$}/{path2:[a-z0-9_\\-]+}")
    public String page2(@PathVariable String path1, @PathVariable String path2) {
        return path1 + "/" + path2;
    }

    /**
     * <pre>
     * page1: 三级目录请求处理，除去api请求
     * </pre>
     * 
     * @author: pengfei 2015年10月23日
     * @param path1
     *            一级目录
     * @return
     */
    @RequestMapping(value = "/{path1:^(?:(?!api)[a-z0-9_\\-])+$}/{path2:[a-z0-9_\\-]+}/{path3:[a-z0-9_\\-]+}")
    public String page3(@PathVariable String path1, @PathVariable String path2, @PathVariable String path3) {
        return path1 + "/" + path2 + "/" + path3;
    }
}
