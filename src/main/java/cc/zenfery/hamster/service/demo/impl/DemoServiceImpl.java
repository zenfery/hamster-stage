package cc.zenfery.hamster.service.demo.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.zenfery.hamster.dao.demo.DemoDao;
import cc.zenfery.hamster.model.demo.Demo;
import cc.zenfery.hamster.service.demo.DemoService;

/**
 * <pre>
 * Demo Service implement
 * </pre>
 * 
 * @author pengfei.cheng 2015年5月13日
 * @since JDK 1.7
 */
@Service
public class DemoServiceImpl implements DemoService {

    private Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private DemoDao demoDao;

    /**
     * @author pengfei.cheng 2015年5月13日
     * @see com.chinacache.web.base.service.demo.DemoService#queryDemo(int)
     */
    @Override
    public Demo queryDemo(int demoid) {
        return demoDao.queryDemo(demoid);
    }

    /**
     * @author pengfei.cheng 2015年5月17日
     * @see com.chinacache.web.base.service.demo.DemoService#updateDemo(com.chinacache.web.base.model.demo.Demo)
     */
    @Override
    public boolean updateDemo(Demo demo) {

        logger.debug("update demo[" + demo.getId() + "] name to 1.");
        demo.setName(demo.getName() + "_1");
        demoDao.updateDemo(demo);

        if (demo.getSex() == '1') {
            throw new RuntimeException(" assume an invoke exception. ");
        }

        logger.debug("update demo[" + demo.getId() + "] name to 2.");
        demo.setName(demo.getName() + "_2");
        demoDao.updateDemo(demo);

        return true;
    }

}
