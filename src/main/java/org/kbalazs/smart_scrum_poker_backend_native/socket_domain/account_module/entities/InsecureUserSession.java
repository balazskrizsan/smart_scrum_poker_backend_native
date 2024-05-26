package org.kbalazs.smart_scrum_poker_backend_native.socket_domain.account_module.entities;

import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record InsecureUserSession(
    UUID insecureUserIdSecure,
    UUID sessionId,
    @NonNull LocalDateTime createdAt
)
{
}
