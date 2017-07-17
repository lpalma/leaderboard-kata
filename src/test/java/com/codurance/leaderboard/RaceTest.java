package com.codurance.leaderboard;

import org.junit.Test;

import static com.codurance.leaderboard.Points.*;
import static com.codurance.leaderboard.TestData.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RaceTest {

    @Test
    public void itShouldDisplayDriverName() {
        String driverName = "Self Driving Car - Acme (1.2)";

        assertEquals(driverName, TestData.race4.getDriverName(SELF_DRIVER));
    }

    @Test public void
    return_the_points_for_each_driver_according_to_their_final_position() {
        Driver Massa = new Driver("Massa", "");
        Driver Lewis = new Driver("Lewis", "");
        Driver Manolo = new Driver("Manolo", "");
        Driver Nico = new Driver("Nico", "");
        Race race = new Race("Interlagos", Massa, Lewis, Manolo, Nico);

        assertThat(race.pointsFor(Massa), is(FIRST_POSITION_POINTS));
        assertThat(race.pointsFor(Lewis), is(SECOND_POSITION_POINTS));
        assertThat(race.pointsFor(Manolo), is(THIRD_POSITION_POINTS));
        assertThat(race.pointsFor(Nico), is(0));
    }
}
