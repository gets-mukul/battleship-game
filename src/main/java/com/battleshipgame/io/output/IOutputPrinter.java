package com.battleshipgame.io.output;

import com.battleshipgame.model.player.Player;

import java.util.List;

public interface IOutputPrinter {
    void printMsg(String s);

    void printSelfBoard(Player currentPlayer);

    void printOpponentBoard(List<Player> players, Player currentPlayer);

    void printWinner(Player winner);
}
