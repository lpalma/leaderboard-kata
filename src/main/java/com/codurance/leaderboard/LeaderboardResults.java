package com.codurance.leaderboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaderboardResults {
    private List<Race> races;

    public LeaderboardResults(List<Race> races) {
        this.races = races;
    }

    public Map<String, Integer> driverResults() {
        Map<String, Integer> results = new HashMap<>();
        for (Race race : this.races) {
            calculateResults(results, race);
        }
        return results;
    }

    private Map<String, Integer> getRaceResult(Race race) {
        Map<String, Integer> result = new HashMap<>();
        for (Driver driver : race.getResults()) {
            String driverName = race.getDriverName(driver);
            int points = race.getPoints(driver);
            result.put(driverName, points);
        }
        return result;
    }

    private void calculateResults(Map<String, Integer> results, Race race) {
        this.getRaceResult(race).entrySet().forEach(
                raceResult -> results.merge(
                        raceResult.getKey(),
                        raceResult.getValue(),
                        (v1, v2) -> v1 + v2));
    }
}
