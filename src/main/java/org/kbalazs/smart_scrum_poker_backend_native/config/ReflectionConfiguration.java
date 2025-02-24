package org.kbalazs.smart_scrum_poker_backend_native.config;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

import static org.springframework.aot.hint.MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS;
import static org.springframework.aot.hint.MemberCategory.INVOKE_PUBLIC_METHODS;
import static org.springframework.aot.hint.MemberCategory.PUBLIC_FIELDS;

@Configuration
@RegisterReflectionForBinding({
    org.springframework.http.ResponseEntity.class,
    ch.qos.logback.classic.LoggerContext.class,
    ch.qos.logback.core.spi.ContextAwareBase.class,
    org.kbalazs.smart_scrum_poker_backend_native.db.tables.records.FlywaySchemaHistoryRecord.class,
    org.kbalazs.smart_scrum_poker_backend_native.db.tables.records.InGamePlayersRecord.class,
    org.kbalazs.smart_scrum_poker_backend_native.db.tables.records.InsecureUserRecord.class,
    org.kbalazs.smart_scrum_poker_backend_native.db.tables.records.InsecureUserSessionsRecord.class,
    org.kbalazs.smart_scrum_poker_backend_native.db.tables.records.PokerRecord.class,
    org.kbalazs.smart_scrum_poker_backend_native.db.tables.records.TicketRecord.class,
    org.kbalazs.smart_scrum_poker_backend_native.db.tables.records.VoteRecord.class,
    org.kbalazs.smart_scrum_poker_backend_native.api.value_objects.ResponseData.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.account_module.entities.InsecureUser.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.account_module.entities.InsecureUserSession.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.common_module.value_objects.ConnectResponse.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.common_module.value_objects.DisconnectResponse.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.entities.InGamePlayer.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.entities.Poker.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.entities.Ticket.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.entities.Vote.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.AddTicket.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.GameStateRequest.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.StartPoker.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.StartPokerResponse.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.VoteStat.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.VotesWithVoteStat.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.VoteValues.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.AddTicketResponse.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.GameStateResponse.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.MyPokersResponse.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.RoundStartResponse.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.SessionResponse.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.StartResponse.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.TicketClosed.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.TicketDeleteResponse.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.VoteNewJoinerResponse.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.VoteResponse.class,
    org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.VoteStopResponse.class,
})
@ImportRuntimeHints(ReflectionConfiguration.AppRuntimeHintsRegistrar.class)
public class ReflectionConfiguration
{
    public static class AppRuntimeHintsRegistrar implements RuntimeHintsRegistrar
    {
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader)
        {
            hints.reflection()
                .registerType(org.springframework.http.ResponseEntity.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(ch.qos.logback.classic.LoggerContext.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(ch.qos.logback.core.spi.ContextAwareBase.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.db.tables.records.FlywaySchemaHistoryRecord.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.db.tables.records.InGamePlayersRecord.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.db.tables.records.InsecureUserRecord.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.db.tables.records.InsecureUserSessionsRecord.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.db.tables.records.PokerRecord.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.db.tables.records.TicketRecord.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.db.tables.records.VoteRecord.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.api.value_objects.ResponseData.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.account_module.entities.InsecureUser.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.account_module.entities.InsecureUserSession.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.common_module.value_objects.ConnectResponse.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.common_module.value_objects.DisconnectResponse.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.entities.InGamePlayer.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.entities.Poker.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.entities.Ticket.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.entities.Vote.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.AddTicket.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.GameStateRequest.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.StartPoker.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.StartPokerResponse.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.VoteStat.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.VotesWithVoteStat.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.VoteValues.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.AddTicketResponse.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.GameStateResponse.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.MyPokersResponse.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.RoundStartResponse.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.SessionResponse.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.StartResponse.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.TicketClosed.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.TicketDeleteResponse.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.VoteNewJoinerResponse.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.VoteResponse.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
                .registerType(org.kbalazs.smart_scrum_poker_backend_native.socket_api.responses.poker.VoteStopResponse.class, PUBLIC_FIELDS, INVOKE_PUBLIC_METHODS, INVOKE_PUBLIC_CONSTRUCTORS)
            ;
        }
    }
}
