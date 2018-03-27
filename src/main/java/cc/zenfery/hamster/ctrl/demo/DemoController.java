package cc.zenfery.hamster.ctrl.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.zenfery.hamster.common.exception.ResponseRuntimeException;
import cc.zenfery.hamster.common.response.ErrorCode;

@Controller
public class DemoController {

    // 测试异常情况
    @RequestMapping("/api/demo/error")
    @ResponseBody
    public String demoError(@RequestParam(required = false) boolean flag) {
        if (!flag) {
            throw new ResponseRuntimeException(ErrorCode.COMMON_ERROR);
        }
        return "error";
    }

    // 测试异常情况
    @RequestMapping("/api/demo/chinese")
    @ResponseBody
    public Map<String, String> demoChinese(@RequestParam(required = false) boolean flag) {
        return new HashMap<String, String>() {
            {
                put("data", "中文");
            }
        };
    }
}
