package org.kbalazs.smart_scrum_poker_backend_native.common.servies;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.kbalazs.smart_scrum_poker_backend_native.config.LogBackState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class Slf4jLongTermLoggerService
{
    private final LogBackState logBackState;

    private Map<String, Logger> loggers = new HashMap<>();

    public void info(@NonNull Class<?> clazz, @NonNull String message)
    {
        Logger logger = loggers.computeIfAbsent(clazz.getName(), k -> LoggerFactory.getLogger(clazz));

        try
        {
            logBackState.setThreadLocalLongTermLogState(true);
            logger.info(message);
        }
        finally
        {
            logBackState.setThreadLocalLongTermLogState(false);
        }
    }
}
