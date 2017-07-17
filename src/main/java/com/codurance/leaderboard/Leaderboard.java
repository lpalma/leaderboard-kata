package com.codurance.leaderboard;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
}
