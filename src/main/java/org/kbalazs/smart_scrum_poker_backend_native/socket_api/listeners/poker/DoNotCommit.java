package org.kbalazs.smart_scrum_poker_backend_native.socket_api.listeners.poker;

import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
import org.kbalazs.smart_scrum_poker_backend_native.api.exceptions.ApiException;
import org.kbalazs.smart_scrum_poker_backend_native.socket_api.requests.poker.StartRequest;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.exceptions.PokerException;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.UUID;

//@Slf4j
@Controller
@RequiredArgsConstructor
public class DoNotCommit
{
    private final SimpMessagingTemplate template;

    @MessageMapping("/broadcast")
    @SendTo("/topic/reply")
    public String sendMessage(@Payload StartRequest request) throws PokerException
    {
        return "rsp: /broadcast";

    }

    @MessageMapping("/user-message-{userName}")
    public void sendToOtherUser(
        @Payload String message,
        @DestinationVariable String userName,
        @Header("simpSessionId") String sessionId
    )
    {
        template.convertAndSend("/queue/reply-" + userName, "You have a message from someone: " + message);
    }

    @MessageMapping("/poker-game-{pokerIdSecure}")
    public void gameHandler(@Payload String message, @DestinationVariable UUID pokerIdSecure)
        throws ApiException
    {
//        notificationService.notifyPokerGame(pokerIdSecure, message, POKER_START);
    }
}
