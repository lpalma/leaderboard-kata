package com.codurance.leaderboard;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codurance.leaderboard.Race.*;
import static org.junit.Assert.assertTrue;

public class LeaderboardResultsTest {

    public static final Driver MANOLO = new Driver("Manolo", "CAT");
    public static final Driver MASSA = new Driver("Massa", "BR");
    public static final Driver CHUN_JE = new Driver("Chun Je", "CH");
    public static final Race INDIANAPOLIS = new Race("Indianapolis", MASSA, CHUN_JE, MANOLO);
    public static final Race MONTMELO = new Race("Montmelo", MANOLO, MASSA, CHUN_JE);

    @Test
    public void itShouldSumThePoints() {

        List<Race> races = Arrays.asList(MONTMELO, INDIANAPOLIS);

        LeaderboardResults boardResults = new LeaderboardResults(races);

        Map<String, Integer> results = new HashMap<>();
        results.put(MANOLO.getName(), FIRST_POSITION_POINTS + THIRD_POSITION_POINTS);
        results.put(MASSA.getName(), SECOND_POSITION_POINTS + FIRST_POSITION_POINTS);
        results.put(CHUN_JE.getName(), THIRD_POSITION_POINTS + SECOND_POSITION_POINTS);

        assertTrue(boardResults.driverResults().equals(results));
    }

}