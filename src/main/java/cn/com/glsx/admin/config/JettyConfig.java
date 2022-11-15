package cn.com.glsx.admin.config;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;

//@Configuration
public class JettyConfig {

    //@Bean
    public JettyServletWebServerFactory jettyEmbeddedServletContainerFactory(JettyServerCustomizer jettyServerCustomizer) {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.addServerCustomizers(jettyServerCustomizer);
        return factory;
    }

    //@Bean
    public JettyServerCustomizer jettyServerCustomizer() {
        return server -> {
            configJettyServer(server);
            threadPool(server);
        };
    }

    public void configJettyServer(Server server) {
        ServerConnector connector = server.getBean(ServerConnector.class);
        connector.setIdleTimeout(1800000);
    }

    public void threadPool(Server server) {
        // Tweak the connection config used by Jetty to handle incoming HTTP
        // connections
        final QueuedThreadPool threadPool = server.getBean(QueuedThreadPool.class);
        //默认最大线程连接数200
        threadPool.setMaxThreads(200);
        //默认最小线程连接数8
        threadPool.setMinThreads(20);
        //默认线程最大空闲时间60000ms
        threadPool.setIdleTimeout(1800000);
    }

}
