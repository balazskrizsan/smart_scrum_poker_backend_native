package org.kbalazs.smart_scrum_poker_backend_native.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class ApplicationProperties
{
    @Value("${server.port}")
    private String serverPort;

    @Value("${server.socker.full.host}")
    private String serverSocketFullHost;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private int dataSourceHikariMaximumPoolSize;

    @Value("${spring.datasource.hikari.minimum-idle}")
    private int dataSourceHikariMinimumIdle;

    @Value("${socket.is-enabled-socket-connect-and-disconnect-listeners}")
    public boolean isEnabledSocketConnectAndDisconnectListeners;

    public String siteP12KeyStoreFilePath()
    {
        return "classpath:keystore/dev.p12";
    }

    @Value("${native.reflection-configuration-generator.enabled}")
    public boolean NativeReflectionConfigurationGeneratorEnabled;
}
