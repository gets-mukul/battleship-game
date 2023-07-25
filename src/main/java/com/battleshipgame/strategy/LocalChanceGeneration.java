package com.battleshipgame.strategy;

import com.battleshipgame.exceptions.InvalidInputException;
import com.battleshipgame.io.input.IInputProvider;
import com.battleshipgame.io.input.PlayerInput;
import com.battleshipgame.model.Coordinate;
import com.battleshipgame.model.PlayerChanceTarget;
import com.battleshipgame.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
public class LocalChanceGeneration implements IChanceGenerationStrategy {

    private final IInputProvider inputProvider;

    @Override
    public PlayerChanceTarget getPlayerChanceTarget(@NonNull final List<Player> opponents) {
        final PlayerInput playerInput = inputProvider.takeInput();
        Player targetPlayer = null;

        for (Player player : opponents) {
            if (player.getId() == playerInput.getPlayerNum()) {
                targetPlayer = player;
            }
        }

        if (targetPlayer == null) {
            throw new InvalidInputException();
        }
        return new PlayerChanceTarget(targetPlayer, new Coordinate(playerInput.getTargetX(), playerInput.getTargetY()));
    }
}
