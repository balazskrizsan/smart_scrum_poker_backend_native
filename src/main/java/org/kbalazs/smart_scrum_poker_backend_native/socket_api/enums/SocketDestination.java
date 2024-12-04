package org.kbalazs.smart_scrum_poker_backend_native.socket_api.enums;

public enum SocketDestination
{
    SESSION_CREATED_OR_UPDATED("/app/session.created_or_updated"),
    SESSION_CLOSED("/app/session.closed"),
    POKER_START("/app/poker/start"),
    POKER_GAME_STATE("/app/poker/game.state"),
    POKER_ROUND_START("/app/poker/vote.start"),
    POKER_TICKET_CLOSE("/app/poker/ticket.close"),
    POKER_TICKET_DELETE("/app/poker/ticket.delete"),
    POKER_ROUND_STOP("/app/poker/vote.stop"),
    SEND_POKER_VOTE("/app/poker/vote"),
    SEND__POKER__NEW_TICKET_CREATE("/app/poker/new.ticket.create"),
    SEND__POKER__MY_TICKETS("/app/poker/my.tickets"),
    SEND_POKER_VOTE_NEW_JOINER("/app/poker/vote.new_joiner"),
    SEND_ACCOUNT_INSECURE_USER_CREATE("/app/account/insecure.user.create");

    private final String destination;

    public String getValue()
    {
        return destination;
    }

    SocketDestination(String destination)
    {
        this.destination = destination;
    }
}
