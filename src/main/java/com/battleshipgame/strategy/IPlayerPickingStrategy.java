package com.battleshipgame.strategy;

import com.battleshipgame.model.player.Player;

import java.util.List;

public interface IPlayerPickingStrategy {
    Integer firstPLayer(List<Player> players);

    Integer pickNextPlayer(Integer currentPLayerIndex, List<Player> players);
}
