package org.kbalazs.smart_scrum_poker_backend_native.socket_api.services;

import lombok.NonNull;
import org.kbalazs.smart_scrum_poker_backend_native.socket_api.requests.account.InsecureUserCreateRequest;
import org.kbalazs.smart_scrum_poker_backend_native.socket_api.requests.poker.StartRequest;
import org.kbalazs.smart_scrum_poker_backend_native.socket_api.requests.poker.VoteRequest;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.account_module.entities.InsecureUser;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.entities.Poker;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.entities.Ticket;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.entities.Vote;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.StartPoker;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class RequestMapperService
{
    public static LocalDateTime getNow()
    {
        return new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static StartPoker mapToEntity(@NonNull StartRequest request)
    {
        return new StartPoker(
            new Poker(
                null,
                null,
                request.sprintTitle(),
                getNow(),
                request.starterInsecureUserId()
            ),
            request.ticketNames().stream().map(tn -> new Ticket(null, null, null, tn, false)).toList()
        );
    }

    public static Vote mapToEntity(@NonNull VoteRequest voteRequest)
    {
        return new Vote(
            null,
            voteRequest.ticketId(),
            voteRequest.voteUncertainty(),
            voteRequest.voteComplexity(),
            voteRequest.voteEffort(),
            null,
            getNow(),
            voteRequest.userIdSecure()
        );
    }

    public static InsecureUser mapToEntity(@NonNull InsecureUserCreateRequest insecureUserCreateRequest)
    {
        return new InsecureUser(
            null,
            null,
            insecureUserCreateRequest.userName(),
            getNow()
        );
    }
}
