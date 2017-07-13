package com.codurance.leaderboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leaderboard {

    private final List<Race> races;

    public Leaderboard(Race... races) {
        this.races = Arrays.asList(races);
    }

    public Map<String, Integer> driverResults() {
        LeaderboardResults results = new LeaderboardResults(races);

        return results.driverResults();
    }

    public List<String> driverRankings() {
        Map<String, Integer> results = driverResults();
        List<String> resultsList = new ArrayList<>(results.keySet());
        Collections.sort(resultsList, new DriverByPointsDescendingComparator(results));
        return resultsList;
    }

    private static final class DriverByPointsDescendingComparator implements Comparator<String> {
        private final Map<String, Integer> results;

        private DriverByPointsDescendingComparator(Map<String, Integer> results) {
            this.results = results;
        }

        @Override
        public int compare(String driverName1, String driverName2) {
            return -results.get(driverName1).compareTo(results.get(driverName2));
        }
    }

    static class LeaderboardResults {
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
}
