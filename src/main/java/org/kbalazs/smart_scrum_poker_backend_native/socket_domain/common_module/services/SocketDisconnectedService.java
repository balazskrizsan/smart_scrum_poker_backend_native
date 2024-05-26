package org.kbalazs.smart_scrum_poker_backend_native.socket_domain.common_module.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
//import lombok.extern.log4j.Log4j2;
import org.kbalazs.smart_scrum_poker_backend_native.socket_api.exceptions.SocketException;
import org.kbalazs.smart_scrum_poker_backend_native.socket_api.services.SocketConnectionHandlerService;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.account_module.entities.InsecureUserSession;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.account_module.exceptions.SessionException;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.account_module.services.InsecureUserSessionsService;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.common_module.value_objects.DisconnectResponse;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
//@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SocketDisconnectedService
{
    InsecureUserSessionsService insecureUserSessionsService;
    SocketConnectionHandlerService socketConnectionHandlerService;

    // @todo: test
    public DisconnectResponse disconnect(MessageHeaders headers) throws SessionException, SocketException
    {
        UUID sessionId = socketConnectionHandlerService.getSessionId(headers);
        InsecureUserSession insecureUserSession = insecureUserSessionsService.getInsecureUserSession(sessionId);

        insecureUserSessionsService.removeBySessionId(sessionId);

        return new DisconnectResponse(
            insecureUserSessionsService.countByIdSecure(insecureUserSession.insecureUserIdSecure()) == 0,
            insecureUserSession
        );
    }
}
