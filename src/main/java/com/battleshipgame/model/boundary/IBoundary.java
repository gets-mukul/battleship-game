package com.battleshipgame.model.boundary;

import com.battleshipgame.model.Coordinate;
import lombok.NonNull;

import java.util.List;

public interface IBoundary {

    boolean contains(@NonNull Coordinate coordinate);

    List<Coordinate> allCoordinates();
}
