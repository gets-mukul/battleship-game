package com.battleshipgame.model;

import com.battleshipgame.exceptions.CoordinateOutOfBoundException;
import com.battleshipgame.model.boundary.IBoundary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {

    private final List<BoardItem> ships;
    private final IBoundary boundary;
    private final List<Coordinate> allBombLocations;

    public Board(@NonNull final List<BoardItem> ships, @NonNull final IBoundary boundary) {
        this.ships = ships;
        this.boundary = boundary;
        this.allBombLocations = new ArrayList<>();
    }

    public boolean areAllShipsKiller() {

        for (BoardItem ship : ships) {
            if (!ship.isKilled(allBombLocations)) {
                return false;
            }
        }
        return true;
    }

    public void takeHit(@NonNull final Coordinate coordinate) {
        if (!boundary.contains(coordinate)) {
            throw new CoordinateOutOfBoundException();
        }

        allBombLocations.add(coordinate);
    }

    public List<Coordinate> hitLocations() {
        final List<Coordinate> result = new ArrayList<>();

        for (Coordinate coordinate : allBombLocations) {
            for (BoardItem ship : ships) {
                if (ship.containsCoordinates(coordinate)) {
                    result.add(coordinate);
                    break;
                }
            }
        }
        return result;
    }

    public List<Coordinate> missLocations() {
        final List<Coordinate> result = new ArrayList<>();

        for (Coordinate coordinate : allBombLocations) {
            boolean doesBelongToShip = false;
            for (BoardItem ship : ships) {
                if (ship.containsCoordinates(coordinate)) {
                    doesBelongToShip = true;
                    break;
                }
            }
            if (!doesBelongToShip) {
                result.add(coordinate);
            }
        }

        return result;
    }
}
