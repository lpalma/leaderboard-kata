package com.codurance.leaderboard;

public class SelfDrivingCar extends Driver {

    private String algorithmVersion;
    private String company;

    public SelfDrivingCar(String algorithmVersion, String company) {
        super(algorithmVersion, "", 0);
        this.algorithmVersion = algorithmVersion;
        this.company = company;
    }

    public String getAlgorithmVersion() {
        return algorithmVersion;
    }

    public void setAlgorithmVersion(String algorithmVersion) {
        this.algorithmVersion = algorithmVersion;
    }

    @Override
    public String getName() {
        return "Self Driving Car - " + this.company + " (" + this.getAlgorithmVersion() + ")";
    }
}
