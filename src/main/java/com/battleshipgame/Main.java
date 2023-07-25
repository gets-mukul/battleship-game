package com.battleshipgame;

import com.battleshipgame.io.input.IInputProvider;
import com.battleshipgame.io.input.SysInInputProvider;
import com.battleshipgame.io.output.SysOutOutputPrinter;
import com.battleshipgame.model.Board;
import com.battleshipgame.model.BoardItem;
import com.battleshipgame.model.Coordinate;
import com.battleshipgame.model.boundary.IBoundary;
import com.battleshipgame.model.boundary.RectangularBoundary;
import com.battleshipgame.model.player.Player;
import com.battleshipgame.strategy.DefaultWinnerStrategy;
import com.battleshipgame.strategy.LocalChanceGeneration;
import com.battleshipgame.strategy.RoundRobinPlayerPickingStrategy;
import lombok.NonNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        final IInputProvider inputProvider = new SysInInputProvider();

        List<Player> players = new ArrayList<>();
        players.add(getPlayer1(inputProvider));
        players.add(getPlayer2(inputProvider));

        GameLoop gameLoop = new GameLoop(players, new DefaultWinnerStrategy(),
                new SysOutOutputPrinter(),
                new RoundRobinPlayerPickingStrategy());
        gameLoop.initGame();
    }

    private static Player getPlayer1(@NonNull final IInputProvider inputProvider) {
        final IBoundary boardBoundary = new RectangularBoundary(new Coordinate(0, 10),
                                                                new Coordinate(10, 0));

        BoardItem ship1 = new BoardItem("A-SH1",
                new RectangularBoundary(new Coordinate(0, 7), new Coordinate(4, 7)));
        BoardItem ship2 = new BoardItem("A-SH2",
                new RectangularBoundary(new Coordinate(4, 1), new Coordinate(4, 4)));
        BoardItem ship3 = new BoardItem("A-SH3",
                new RectangularBoundary(new Coordinate(7, 3), new Coordinate(7, 5)));
        BoardItem ship4 = new BoardItem("A-SH4",
                new RectangularBoundary(new Coordinate(4, 9), new Coordinate(6, 9)));
        BoardItem ship5 = new BoardItem("A-SH5",
                new RectangularBoundary(new Coordinate(3, 6), new Coordinate(4, 3)));

        ArrayList<BoardItem> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);
        ships.add(ship3);
        ships.add(ship4);
        ships.add(ship5);

        Board board = new Board(ships, boardBoundary);

        return new Player(board, 1, new LocalChanceGeneration(inputProvider));
    }

    private static Player getPlayer2(@NonNull final IInputProvider inputProvider) {
        final IBoundary boardBoundary = new RectangularBoundary(new Coordinate(0, 10),
                                                                new Coordinate(10, 0));

        BoardItem ship1 = new BoardItem("B-SH1",
                new RectangularBoundary(new Coordinate(0, 7), new Coordinate(4, 7)));
        BoardItem ship2 = new BoardItem("B-SH2",
                new RectangularBoundary(new Coordinate(4, 1), new Coordinate(4, 4)));
        BoardItem ship3 = new BoardItem("B-SH3",
                new RectangularBoundary(new Coordinate(7, 3), new Coordinate(7, 5)));
        BoardItem ship4 = new BoardItem("B-SH4",
                new RectangularBoundary(new Coordinate(4, 9), new Coordinate(6, 9)));
        BoardItem ship5 = new BoardItem("B-SH5",
                new RectangularBoundary(new Coordinate(3, 6), new Coordinate(4, 3)));

        ArrayList<BoardItem> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);
        ships.add(ship3);
        ships.add(ship4);
        ships.add(ship5);

        Board board = new Board(ships, boardBoundary);

        return new Player(board, 2, new LocalChanceGeneration(inputProvider));
    }


}
