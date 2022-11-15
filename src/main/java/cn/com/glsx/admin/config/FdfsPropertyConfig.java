package cn.com.glsx.admin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * FastDFS 配置类
 *
 * @author yll
 */
@Configuration
@ConfigurationProperties(prefix = "fdfs")
public class FdfsPropertyConfig {
    /**
     * 图片服务器的地址
     */
    private String trackerNginxDomain;

    public String getTrackerNginxDomain() {
        return trackerNginxDomain;
    }

    public void setTrackerNginxDomain(String trackerNginxDomain) {
        this.trackerNginxDomain = trackerNginxDomain;
    }
}
