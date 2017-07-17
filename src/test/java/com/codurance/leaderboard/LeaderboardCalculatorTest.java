package com.codurance.leaderboard;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LeaderboardCalculatorTest {

    private Driver MANOLO = new Driver("Manolo", "", 0);
    private Driver LEWIS = new Driver("Lewis", "", 0);
    private Driver MASSA = new Driver("Massa", "", 0);


    @Test
    public void return_drivers_ordered_by_points() throws Exception {
        LeaderboardCalculator leaderboardCalculator = new LeaderboardCalculator(Arrays.asList(
                new Race("Monaco", MANOLO, MASSA, LEWIS),
                new Race("Silverstone", MANOLO, LEWIS, MASSA),
                new Race("Interlagos", MANOLO, MASSA, LEWIS)
        ));
        List<Driver> drivers = leaderboardCalculator.driversByPoint();
        System.out.println(drivers);
        assertThat(drivers, is(asList(
                                    MANOLO,
                                    MASSA,
                                    LEWIS)));
    }
}