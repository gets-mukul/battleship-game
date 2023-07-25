package com.battleshipgame;

import com.battleshipgame.exceptions.CoordinateOutOfBoundException;
import com.battleshipgame.io.output.IOutputPrinter;
import com.battleshipgame.model.PlayerChanceTarget;
import com.battleshipgame.model.player.Player;
import com.battleshipgame.strategy.IPlayerPickingStrategy;
import com.battleshipgame.strategy.IWinnerStrategy;
import lombok.NonNull;

import java.util.List;

public class GameLoop {

    private final List<Player> players;
    private final IWinnerStrategy winnerStrategy;
    private final IOutputPrinter printer;
    private final IPlayerPickingStrategy nextPlayerStrategy;

    public GameLoop(@NonNull final List<Player> players, @NonNull final IWinnerStrategy winnerStrategy,
                    @NonNull final IOutputPrinter printer, @NonNull final IPlayerPickingStrategy nextPlayerStrategy) {
        this.players = players;
        this.winnerStrategy = winnerStrategy;
        this.printer = printer;
        this.nextPlayerStrategy = nextPlayerStrategy;
    }

    public void initGame(){
        int  currentPLayerIndex = nextPlayerStrategy.firstPLayer(this.players);
        printer.printMsg("Starting game !!!!");
        while (true){
            final Player currentPlayer = players.get(currentPLayerIndex);
            printer.printMsg("\n\nPLayer: " + currentPlayer.getId() + " chance:");
            final PlayerChanceTarget playerChanceTarget = currentPlayer.takeChance(this.players);

            try{
                playerChanceTarget.getTargetPlayer().takeHit(playerChanceTarget.getTarget());
            }catch (CoordinateOutOfBoundException exception){
                printer.printMsg("!!!!!!!!!!!!!!!! Hit was out of bound !!!!!!!!!!!!!!!!!!!\n\n" );
            }

            printer.printSelfBoard(currentPlayer); //viewBattleField
            printer.printOpponentBoard(players, currentPlayer);

            final Player winner = winnerStrategy.getWinner(players);
            if(winner != null){
                printer.printWinner(winner);
                break;
            }

            currentPLayerIndex = nextPlayerStrategy.pickNextPlayer(currentPLayerIndex, this.players);
        }
    }
}


