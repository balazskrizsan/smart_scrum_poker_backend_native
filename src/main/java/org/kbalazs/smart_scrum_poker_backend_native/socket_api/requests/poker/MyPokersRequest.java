package org.kbalazs.smart_scrum_poker_backend_native.socket_api.requests.poker;

import lombok.NonNull;

import java.util.UUID;

public record MyPokersRequest(@NonNull UUID userIdInsecure)
{
}
