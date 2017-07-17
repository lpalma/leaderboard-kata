package com.codurance.leaderboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

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
        races.forEach(r ->
                r.drivers().forEach( d -> {
                    int points = leaderboard.getOrDefault(d.getName(), 0);
                    leaderboard.put(d.getName(), points + r.pointsFor(d));
                }));
        return leaderboard;
    }

}
