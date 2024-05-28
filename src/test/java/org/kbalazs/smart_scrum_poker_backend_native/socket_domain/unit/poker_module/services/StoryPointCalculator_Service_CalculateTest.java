package org.kbalazs.smart_scrum_poker_backend_native.socket_domain.unit.poker_module.services;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.kbalazs.smart_scrum_poker_backend_native.helpers.AbstractTest;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.exceptions.StoryPointException;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.services.StoryPointCalculatorService;
import org.kbalazs.smart_scrum_poker_backend_native.socket_domain.poker_module.value_objects.VoteValues;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StoryPointCalculator_Service_CalculateTest extends AbstractTest
{
    @Test
    @SneakyThrows
    public void calculationWithBadValues_throwsException()
    {
        // Arrange
        var testedVote = new VoteValues(false, false, (short) 10L, (short) 10L, (short) 10L);

        // Act - Assert
        assertThatThrownBy(() -> createInstance(StoryPointCalculatorService.class).calculate(testedVote))
            .isInstanceOf((StoryPointException.class))
            .hasMessage("Not implemented");
    }

    @SneakyThrows
    @ParameterizedTest
    @MethodSource("validScenarios_returnsWithExpectedStoryPoint_provider")
    public void validScenarios_returnsWithExpectedStoryPoint(VoteValues voteValues, Short expectedCalculation)
    {
        // Arrange - In provider
        // Act
        var actualCalculation = createInstance(StoryPointCalculatorService.class).calculate(voteValues);

        // Assert
        assertThat(actualCalculation).isEqualTo(expectedCalculation);
    }

    private static Stream<Arguments> validScenarios_returnsWithExpectedStoryPoint_provider()
    {
        return Stream.of(
            Arguments.of(
                new VoteValues(true, false, (short) 1, (short) 1, (short) 1),
                null
            ),
            Arguments.of(
                new VoteValues(false, true, (short) 1, (short) 1, (short) 1),
                null
            ),
            Arguments.of(
                new VoteValues(false, false, (short) 1, (short) 1, (short) 1),
                (short) 1
            ),
            Arguments.of(
                new VoteValues(false, false, (short) 1, (short) 1, (short) 2),
                (short) 2
            ),
            Arguments.of(
                new VoteValues(false, false, (short) 1, (short) 1, (short) 3),
                (short) 5
            )
        );
    }
}
