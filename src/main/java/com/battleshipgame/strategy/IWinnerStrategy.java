package com.battleshipgame.strategy;

import com.battleshipgame.model.player.Player;

import java.util.List;

public interface IWinnerStrategy {
    Player getWinner(List<Player> players);
}
