package com.battleshipgame.strategy;

import com.battleshipgame.exceptions.InvalidInputException;
import com.battleshipgame.model.player.Player;

import java.util.List;

public class RoundRobinPlayerPickingStrategy implements IPlayerPickingStrategy {
    @Override
    public Integer firstPLayer(List<Player> allPLayers) {
        if (allPLayers.size() == 0) {
            throw new InvalidInputException();
        }
        return 0;
    }

    @Override
    public Integer pickNextPlayer(Integer currentPlayerIndex, List<Player> allPlayers) {
        return (currentPlayerIndex + 1) % allPlayers.size();
    }
}
