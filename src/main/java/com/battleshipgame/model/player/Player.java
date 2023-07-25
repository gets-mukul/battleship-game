package com.battleshipgame.model.player;

import com.battleshipgame.model.Board;
import com.battleshipgame.model.Coordinate;
import com.battleshipgame.model.PlayerChanceTarget;
import com.battleshipgame.strategy.IChanceGenerationStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Player {

    private final Board board;
    private final int id;
    private final IChanceGenerationStrategy chanceGenerationStrategy;

    public PlayerChanceTarget takeChance(List<Player> allPlayers){
        List<Player> opponents = new ArrayList<>();
        for(Player player: allPlayers){
            if(player.getId() != getId()){
                opponents.add(player);
            }
        }
        return chanceGenerationStrategy.getPlayerChanceTarget(opponents);
    }

    public boolean areAllShipsKilled(){
        return board.areAllShipsKiller();
    }

    public void takeHit(@NonNull final Coordinate coordinates){
        board.takeHit(coordinates);
    }
}
