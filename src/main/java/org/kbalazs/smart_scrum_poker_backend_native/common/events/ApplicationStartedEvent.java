package org.kbalazs.smart_scrum_poker_backend_native.common.events;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.kbalazs.common.certificate_module.services.ApplicationCertificationInfo;
import org.kbalazs.smart_scrum_poker_backend_native.config.ApplicationProperties;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class ApplicationStartedEvent
{
    private final ApplicationCertificationInfo applicationCertificationInfo;
    private final ApplicationProperties applicationProperties;

    @EventListener(org.springframework.boot.context.event.ApplicationStartedEvent.class)
    @SneakyThrows
    public void onApplicationReady()
    {
        applicationCertificationInfo.log(
            applicationProperties.serverSslKeyStoreType,
            applicationProperties.serverSslKeyStorePassword,
            applicationProperties.siteP12KeyStoreFilePath()
        );
    }
}
