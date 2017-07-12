package com.codurance.leaderboard;

import org.junit.Assert;
import org.junit.Test;

import static com.codurance.leaderboard.Race.FIRST_POSITION_POINTS;
import static com.codurance.leaderboard.Race.SECOND_POSITION_POINTS;
import static com.codurance.leaderboard.Race.THIRD_POSITION_POINTS;
import static com.codurance.leaderboard.TestData.*;
import static org.junit.Assert.assertEquals;

public class RaceTest {

    @Test
    public void isShouldCalculateDriverPoints() {
        // setup

        // act

        // verify
        assertEquals(FIRST_POSITION_POINTS, TestData.race1.getPoints(NICO));
        assertEquals(SECOND_POSITION_POINTS, TestData.race1.getPoints(LEWIS));
        assertEquals(THIRD_POSITION_POINTS, TestData.race1.getPoints(SEBASTIAN));
    }

}
