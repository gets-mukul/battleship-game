package com.battleshipgame.model;

import com.battleshipgame.model.boundary.IBoundary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class BoardItem {

    private final String name;
    private final IBoundary boundary;

    public boolean isKilled(@NonNull final List<Coordinate> bombedLocation) {
        final List<Coordinate> shipCoordinates = boundary.allCoordinates();

        for (Coordinate shipCoordinate : shipCoordinates) {
            if (!bombedLocation.contains(shipCoordinate)) {
                return false;
            }
        }
        return true;
    }

    public boolean containsCoordinates(@NonNull final Coordinate coordinate) {
        return this.boundary.contains(coordinate);
    }
}
