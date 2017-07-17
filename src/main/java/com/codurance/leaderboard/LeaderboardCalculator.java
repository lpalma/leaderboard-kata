package com.codurance.leaderboard;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

class LeaderboardCalculator {
    private List<Race> races;

    LeaderboardCalculator(List<Race> races) {
        this.races = races;
    }

    List<Driver> driversByPoint() {
        Map<String, Integer> leaderboard = calculate();
        return leaderboard.entrySet().stream()
                .map(es -> new Driver(es.getKey(), "", es.getValue()))
                .sorted((d1, d2) -> d1.points() > d2.points() ? -1 : 1)
                .collect(toList());

    }

    private Map<String, Integer> calculate() {
        return this.races.stream()
                .map(toEntrySet())
                .flatMap(Collection::stream)
                .collect(mergeResults());
    }

    private Collector<Map.Entry<String, Integer>, ?, Map<String, Integer>> mergeResults() {
        return Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                Integer::sum
        );
    }

    private Function<Race, Set<Map.Entry<String, Integer>>> toEntrySet() {
        return race -> race.getRaceResult().entrySet();
    }
}
