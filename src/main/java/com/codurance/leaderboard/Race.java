package com.codurance.leaderboard;

import java.util.List;

import static com.codurance.leaderboard.Points.pointsForPosition;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Race {

    private final String name;
    private final List<Driver> drivers;

    Race(String name, Driver... drivers) {
        this.name = name;
        this.drivers = stream(drivers).map(Driver::copy).collect(toList());
    }

    int pointsFor(Driver driver) {
        return pointsForPosition(position(driver));
    }

    List<Driver> drivers() {
        return drivers;
    }

    String getDriverName(Driver driver) {
        return drivers.stream()
                        .filter(d -> d.equals(driver))
                        .findFirst()
                        .orElse(driver)
                        .getName();
    }

    private int position(Driver driver) {
        return this.drivers.indexOf(driver);
    }

    @Override
    public String toString() {
        return name;
    }

}
