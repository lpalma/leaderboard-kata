package com.codurance.leaderboard;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

class Leaderboard {

    private final List<Driver> drivers;

    Leaderboard(Race... races) {
        this.drivers = new LeaderboardCalculator(asList(races)).driversByPoint();
    }

    Map<String, Integer> driverResults() {
        return drivers.stream().collect(toMap(Driver::getName, Driver::points));
    }

    List<String> driverRankings() {
        return drivers.stream().map(Driver::getName).collect(toList());
    }

}
