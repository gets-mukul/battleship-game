package com.battleshipgame.model;

import com.battleshipgame.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerChanceTarget {

    final Player targetPlayer;
    final Coordinate target;
}
