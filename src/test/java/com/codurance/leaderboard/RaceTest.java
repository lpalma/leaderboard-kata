package com.codurance.leaderboard;

import org.junit.Assert;
import org.junit.Test;

import static com.codurance.leaderboard.Race.FIRST_POSITION_POINTS;
import static com.codurance.leaderboard.Race.SECOND_POSITION_POINTS;
import static com.codurance.leaderboard.Race.THIRD_POSITION_POINTS;
import static com.codurance.leaderboard.TestData.LEWIS;
import static com.codurance.leaderboard.TestData.NICO;
import static com.codurance.leaderboard.TestData.SEBASTIAN;

public class RaceTest {

    @Test
    public void isShouldCalculateDriverPoints() {
        // setup

        // act

        // verify
        Assert.assertEquals(FIRST_POSITION_POINTS, TestData.race1.getPoints(NICO));
        Assert.assertEquals(SECOND_POSITION_POINTS, TestData.race1.getPoints(LEWIS));
        Assert.assertEquals(THIRD_POSITION_POINTS, TestData.race1.getPoints(SEBASTIAN));
    }

}
