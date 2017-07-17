package com.codurance.leaderboard;

public class TestData {

    public static Driver NICO;
    public static Driver LEWIS;
    public static Driver SEBASTIAN;
    public static SelfDrivingCar SELF_DRIVER;

    public static Race race1;
    public static Race race2;
    public static Race race3;
    public static Race race4;
    public static Race race5;
    public static Race race6;

    public static Leaderboard sampleLeaderboard1;
    public static Leaderboard sampleLeaderboard2;

    static {
        NICO = new Driver("Nico Rosberg", "DE");
        LEWIS = new Driver("Lewis Hamilton", "UK");
        SEBASTIAN = new Driver("Sebastian Vettel", "DE");
        SELF_DRIVER = new SelfDrivingCar("1.2", "Acme");

        race1 = new Race("Australian Grand Prix", NICO, LEWIS, SEBASTIAN);
        race2 = new Race("Malaysian Grand Prix", SEBASTIAN, LEWIS, NICO);
        race3 = new Race("Chinese Grand Prix", LEWIS, NICO, SEBASTIAN);
        race4 = new Race("Fictional Grand Prix 1", NICO, LEWIS, SELF_DRIVER);
        race5 = new Race("Fictional Grand Prix 2", SELF_DRIVER, LEWIS, NICO);
        SELF_DRIVER.setAlgorithmVersion("1.3");
        race6 = new Race("Fictional Grand Prix 3", LEWIS, NICO, SELF_DRIVER);

        sampleLeaderboard1 = new Leaderboard(race1, race2, race3);
        sampleLeaderboard2 = new Leaderboard(race4, race5, race6);
    }
}
