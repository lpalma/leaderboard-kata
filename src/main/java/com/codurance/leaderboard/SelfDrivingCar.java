package com.codurance.leaderboard;

public class SelfDrivingCar extends Driver {

    private String algorithmVersion;

    public SelfDrivingCar(String algorithmVersion, String company) {
        super(algorithmVersion, company);
        this.algorithmVersion = algorithmVersion;
    }

    public String getAlgorithmVersion() {
        return algorithmVersion;
    }

    public void setAlgorithmVersion(String algorithmVersion) {
        this.algorithmVersion = algorithmVersion;
    }

    @Override
    public String getName() {
        return "Self Driving Car - " + this.getCountry() + " (" + this.getAlgorithmVersion() + ")";
    }
}
