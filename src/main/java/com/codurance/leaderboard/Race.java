package com.codurance.leaderboard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

    public static final int FIRST_POSITION_POINTS = 25;
    public static final int SECOND_POSITION_POINTS = 18;
    public static final int THIRD_POSITION_POINTS = 15;
    private static final Integer[] POINTS = new Integer[]{FIRST_POSITION_POINTS, SECOND_POSITION_POINTS, THIRD_POSITION_POINTS};

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
        return Race.POINTS[position(driver)];
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
