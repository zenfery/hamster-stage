package cc.zenfery.hamster.dao.demo;

import org.springframework.stereotype.Repository;

import cc.zenfery.hamster.model.demo.Demo;

/**
 * <pre>
 * Demo Dao
 * </pre>
 * 
 * @author pengfei.cheng 2015年5月13日
 * @since JDK 1.7
 */
@Repository
public interface DemoDao {

    /**
     * <pre>
     * queryDemo: 演示：根据demo id 查询Demo对象
     * </pre>
     * 
     * @author: pengfei.cheng 2015年5月13日
     * @param demoid
     * @return
     */
    Demo queryDemo(int demoid);

    /**
     * <pre>
     * updateDemo: 根据demo id进行更新
     * </pre>
     * 
     * @author: pengfei.cheng 2015年5月17日
     * @return int
     */
    void updateDemo(Demo demo);
}
