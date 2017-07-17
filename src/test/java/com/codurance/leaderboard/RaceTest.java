package com.codurance.leaderboard;

import org.junit.Assert;
import org.junit.Test;

import static com.codurance.leaderboard.Points.FIRST_POSITION_POINTS;
import static com.codurance.leaderboard.Points.SECOND_POSITION_POINTS;
import static com.codurance.leaderboard.Points.THIRD_POSITION_POINTS;
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

    @Test
    public void itShouldDisplayDriverName() {
        String driverName = "Self Driving Car - Acme (1.2)";

        assertEquals(driverName, TestData.race4.getDriverName(SELF_DRIVER));
    }

}
