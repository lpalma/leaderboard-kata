package com.codurance.leaderboard;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

class Leaderboard {

    private Map<String, Integer> leaderboard = new HashMap<>();

    Leaderboard(Race... races) {
        leaderboard = calculateLeaderboard(asList(races));
    }

    Map<String, Integer> driverResults() {
        return leaderboard;
    }

    List<String> driverRankings() {
        return leaderboard.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    private Map<String, Integer> calculateLeaderboard(List<Race> races) {
        return races.stream()
                .flatMap(race -> race.results().entrySet().stream())
                .collect(toMap(
                        v -> v.getKey().getName(),
                        Map.Entry::getValue,
                        Integer::sum
                ));
    }

}
