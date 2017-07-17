package com.codurance.leaderboard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

    private final String name;
    private final List<Driver> results;
    private final Map<Driver, String> driverNames;

    public Race(String name, Driver... drivers) {
        this.name = name;
        this.results = Arrays.asList(drivers);
        this.driverNames = this.fillDriversName();
    }

    private Map<Driver, String> fillDriversName() {
        Map<Driver, String> result = new HashMap<>();
        for (Driver driver : results) {
            result.put(driver, driver.getName());
        }
        return result;
    }

    public int position(Driver driver) {
        return this.results.indexOf(driver);
    }

    public int getPoints(Driver driver) {
        return Points.pointsForPosition(position(driver));
    }

    public List<Driver> getResults() {
        return results;
    }

    public String getDriverName(Driver driver) {
        return this.driverNames.get(driver);
    }

    @Override
    public String toString() {
        return name;
    }
}
