package com.battleshipgame.io.input;

import com.battleshipgame.exceptions.InvalidInputException;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SysInInputProvider implements IInputProvider {

    @SneakyThrows
    @Override
    public PlayerInput takeInput() {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader br = new BufferedReader(inputStreamReader);
        final String line = br.readLine();

        String[] s = line.split(" ");
        if (s.length != 3) {
            throw new InvalidInputException();
        }

        final int playerNum = Integer.parseInt(s[0]);
        final int targetX = Integer.parseInt(s[1]);
        final int targetY = Integer.parseInt(s[2]);

        return new PlayerInput(playerNum, targetX, targetY);
    }
}
