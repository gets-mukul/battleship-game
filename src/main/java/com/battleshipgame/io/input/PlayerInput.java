package com.battleshipgame.io.input;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerInput {

    private final Integer playerNum;
    private final Integer targetX;
    private final Integer targetY;
}
