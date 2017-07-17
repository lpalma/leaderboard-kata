package com.codurance.leaderboard;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codurance.leaderboard.Points.FIRST_POSITION_POINTS;
import static com.codurance.leaderboard.Points.SECOND_POSITION_POINTS;
import static com.codurance.leaderboard.Points.THIRD_POSITION_POINTS;
import static com.codurance.leaderboard.TestData.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LeaderboardTest {

    public static final Driver MANOLO = new Driver("Manolo", "CAT");
    public static final Driver MASSA = new Driver("Massa", "BR");
    public static final Driver CHUN_JE = new Driver("Chun Je", "CH");
    public static final Race INDIANAPOLIS = new Race("Indianapolis", MASSA, CHUN_JE, MANOLO);
    public static final Race MONTMELO = new Race("Montmelo", MANOLO, MASSA, CHUN_JE);

    @Test
    public void itShouldSumThePoints() {
        Map<String, Integer> results = new HashMap<>();
        results.put(MANOLO.getName(), FIRST_POSITION_POINTS + THIRD_POSITION_POINTS);
        results.put(MASSA.getName(), SECOND_POSITION_POINTS + FIRST_POSITION_POINTS);
        results.put(CHUN_JE.getName(), THIRD_POSITION_POINTS + SECOND_POSITION_POINTS);

        Leaderboard leaderboard = new Leaderboard(MONTMELO, INDIANAPOLIS);

        assertTrue(leaderboard.driverResults().equals(results));
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
        Race australia = new Race("Australian Grand Prix", NICO, LEWIS, SEBASTIAN);
        Race malaysia = new Race("Malaysian Grand Prix", LEWIS, NICO, SEBASTIAN);
        Race brazil = new Race("Brazlian Grand Prix", NICO, LEWIS, SEBASTIAN);
        Leaderboard exEquoLeaderBoard = new Leaderboard(australia, malaysia);

        // act
        List<String> rankings = exEquoLeaderBoard.driverRankings();

        // verify
        assertEquals(Arrays.asList(NICO.getName(), LEWIS.getName(), SEBASTIAN.getName()), rankings);
        // note: the order of NICO and LEWIS is JDK/platform dependent
    }

}
