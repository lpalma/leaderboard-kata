package com.codurance.leaderboard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

    private final String name;
    private final List<Driver> drivers;
    private final Map<Driver, String> driverNames;

    public Race(String name, Driver... drivers) {
        this.name = name;
        this.drivers = Arrays.asList(drivers);
        this.driverNames = this.fillDriversName();
    }

    int pointsFor(Driver driver) {
        return Points.pointsForPosition(position(driver));
    }

    List<Driver> drivers() {
        return drivers;
    }

    String getDriverName(Driver driver) {
        return this.driverNames.get(driver);
    }

    private Map<Driver, String> fillDriversName() {
        Map<Driver, String> result = new HashMap<>();
        for (Driver driver : drivers) {
            result.put(driver, driver.getName());
        }
        return result;
    }

    private int position(Driver driver) {
        return this.drivers.indexOf(driver);
    }

    @Override
    public String toString() {
        return name;
    }

}
