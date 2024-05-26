package org.kbalazs.smart_scrum_poker_backend_native.socket_domain.common_module.value_objects;

import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.account_module.entities.InsecureUserSession;

public record ConnectResponse(boolean shouldSendNotification, InsecureUserSession insecureUserSession)
{
}
