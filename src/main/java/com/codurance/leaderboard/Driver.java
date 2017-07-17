package com.codurance.leaderboard;

public class Driver {

    private final String name;
    private final String country;
    private int points;

    public Driver(String name, String country, int points) {
        this.name = name;
        this.country = country;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int points() {
        return this.points;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", points=" + points +
                '}';
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31 + country.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) obj;
        return this.name.equals(other.name) && this.country.equals(other.country);
    }
}
