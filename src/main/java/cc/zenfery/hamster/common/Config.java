package cc.zenfery.hamster.common;

import org.apache.commons.configuration.AbstractFileConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * config.properties配置
 * 
 * @author pengfei 2015年9月8日
 * @since JDK 1.7
 */
public abstract class Config {

    private static final Log logger = LogFactory.getLog(Config.class);
    private static boolean inited = false;
    private static final int CONFIG_REFRESH_INTERVAL = 1000 * 60; // 读取配置文件的最小间隔时间（毫秒）
    private static PropertiesConfiguration propertiesConfiguration;

    // 配置文件路径
    public static final String CONFIG_PATH_SYSTEM = "config.properties";

    /**
     * 获取指定属性值
     */
    public static String get(String key) {
        if (!inited) {
            propertiesConfiguration = new PropertiesConfiguration();
            initConfig(propertiesConfiguration, Config.CONFIG_PATH_SYSTEM);
            inited = true;
        }
        return propertiesConfiguration.getString(key);
    }

    /**
     * 初始化配置管理对象，包括设置不使用分隔符，设置最短刷新时间为1分钟。可用于 PropertiesConfiguration
     * 
     * @param config
     *            配置管理对象
     * @param path
     *            配置文件
     */
    public static void initConfig(AbstractFileConfiguration config, String path) {
        config.setDelimiterParsingDisabled(true); // 设置不使用分隔符
        try {
            config.load(path);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        FileChangedReloadingStrategy strategy = new FileChangedReloadingStrategy();
        strategy.setRefreshDelay(CONFIG_REFRESH_INTERVAL); // 设置最短刷新间隔为1分钟
        config.setReloadingStrategy(strategy);
    }

}
