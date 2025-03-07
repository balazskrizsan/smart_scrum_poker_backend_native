package org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.services;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.jooq.Configuration;
import org.kbalazs.smart_scrum_poker_backend_native.domain_common.services.JooqService;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.account_module.exceptions.AccountException;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.account_module.services.InsecureUserService;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.common_module.services.UuidService;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.entities.Poker;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.entities.Ticket;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.exceptions.PokerException;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.StartPokerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class StartService
{
    PokerService pokerService;
    InsecureUserService insecureUserService;
    UuidService uuidService;
    TicketService ticketService;
    JooqService jooqService;

    public StartPokerResponse start(@NonNull Poker poker, @NonNull List<Ticket> tickets) throws PokerException, AccountException
    {
        insecureUserService.findByIdSecure(poker.createdBy());

        var newPoker = jooqService.getDbContext().transactionResult(
            (Configuration config) -> transactionalCreate(poker, tickets)
        );

        log.info("New poker started: {}", newPoker); // @TODO: test, monitor

        return new StartPokerResponse(newPoker);
    }

    private Poker transactionalCreate(@NonNull Poker poker, @NonNull List<Ticket> tickets) throws PokerException
    {
        try
        {
            Poker newPoker = pokerService.create(new Poker(
                null,
                uuidService.getRandom(),
                poker.name(),
                poker.createdAt(),
                poker.createdBy()
            ));

            ticketService.createAll(
                tickets.stream()
                    .map(t -> new Ticket(null, null, newPoker.id(), t.name(), t.isActive()))
                    .toList()
            );

            return newPoker;
        }
        catch (Exception e)
        {
            log.error("Poker creation error: {}", e.getMessage(), e); // TODO: test, monitor

            throw e;
        }
    }
}
