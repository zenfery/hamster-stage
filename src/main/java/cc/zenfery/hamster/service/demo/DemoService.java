package cc.zenfery.hamster.service.demo;

import cc.zenfery.hamster.model.demo.Demo;

/**
 * <pre>
 * 演示Service类
 * </pre>
 * 
 * @author pengfei.cheng 2015年5月13日
 * @since JDK 1.7
 */
public interface DemoService {

    /**
     * <pre>
     * queryDemo: 演示Service
     * </pre>
     * 
     * @author: pengfei.cheng 2015年5月13日
     * @param demoid
     * @return
     */
    Demo queryDemo(int demoid);

    /**
     * <pre>
     * updateDemo: 演示Demo更新
     * </pre>
     * 
     * @author: pengfei.cheng 2015年5月17日
     * @param demo
     * @return boolean true代表更新成功
     */
    boolean updateDemo(Demo demo);
}
