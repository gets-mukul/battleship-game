package com.battleshipgame.strategy;

import com.battleshipgame.model.PlayerChanceTarget;
import com.battleshipgame.model.player.Player;

import java.util.List;

public interface IChanceGenerationStrategy {

    PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents);
}
