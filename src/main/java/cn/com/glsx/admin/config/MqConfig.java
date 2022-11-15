package cn.com.glsx.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangxw
 * @version 1.0.0
 * @ClassName KafkaProductorConfig.java
 * @description: ${description}
 * @createTime 2020年10月20日 10:21:00
 */
@Data
@Configuration
@ConfigurationProperties("mq.kafka.neshield")
public class MqConfig {

    /**
     * kafka 生产者服务端地址
     */
    private String producerServers;

    /**
     * 围栏规则数据发送 topic
     */
    private String eFenceTopic;

}
