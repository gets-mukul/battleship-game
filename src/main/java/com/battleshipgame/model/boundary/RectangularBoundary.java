package com.battleshipgame.model.boundary;

import com.battleshipgame.model.Coordinate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class RectangularBoundary implements IBoundary {
    private final Coordinate topLeft;
    private final Coordinate bottomRight;


    @Override
    public boolean contains(@NonNull Coordinate coordinate) {
        return coordinate.getX() >= topLeft.getX() && coordinate.getX() <= bottomRight.getX()
                && coordinate.getY() >= bottomRight.getY() && coordinate.getY() <= topLeft.getY();
    }

    @Override
    public List<Coordinate> allCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = topLeft.getX(); i <= bottomRight.getX(); i++) {
            for (int j = topLeft.getY(); j >= bottomRight.getY(); j--) {
                coordinates.add(new Coordinate(i, j));
            }
        }
        return coordinates;
    }
}
