package com.codurance.leaderboard;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.codurance.leaderboard.TestData.LEWIS;
import static com.codurance.leaderboard.TestData.NICO;
import static com.codurance.leaderboard.TestData.SEBASTIAN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LeaderboardTest {

    @Test
    public void itShouldSumThePoints() {
        // setup

        // act
        Map<String, Integer> results = TestData.sampleLeaderboard1.driverResults();

        // verify
        assertTrue("results " + results, results.containsKey("Lewis Hamilton"));
        assertEquals(18 + 18 + 25, (int) results.get("Lewis Hamilton"));
    }

    @Test
    public void shouldReturnRankingInProperOrder() {
        // setup

        // act
        List<String> result = TestData.sampleLeaderboard1.driverRankings();

        // verify
        assertEquals(LEWIS.getName(), result.get(0));
        assertEquals(NICO.getName(), result.get(1));
        assertEquals(SEBASTIAN.getName(), result.get(2));
    }

    @Test
    public void itShouldKeepAllDriversWhenSamePoints() {
        // setup
        // bug, drops drivers with same points
        Race winDriver1 = new Race("Australian Grand Prix", NICO, LEWIS, SEBASTIAN);
        Race winDriver2 = new Race("Malaysian Grand Prix", LEWIS, NICO, SEBASTIAN);
        Leaderboard exEquoLeaderBoard = new Leaderboard(winDriver1, winDriver2);

        // act
        List<String> rankings = exEquoLeaderBoard.driverRankings();

        // verify
        assertEquals(Arrays.asList(NICO.getName(), LEWIS.getName(), SEBASTIAN.getName()), rankings);
        // note: the order of NICO and LEWIS is JDK/platform dependent
    }

}
