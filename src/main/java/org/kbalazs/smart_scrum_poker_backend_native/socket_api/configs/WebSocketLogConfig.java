package org.kbalazs.smart_scrum_poker_backend_native.socket_api.configs;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.WebSocketMessageBrokerStats;

@Configuration
@RequiredArgsConstructor
public class WebSocketLogConfig
{
    private final WebSocketMessageBrokerStats webSocketMessageBrokerStats;

    @PostConstruct
    public void init()
    {
        webSocketMessageBrokerStats.setLoggingPeriod(10 * 1000);
    }
}
