package com.codurance.leaderboard;

public class SelfDrivingCar extends Driver {

    private String algorithmVersion;
    private String company;

    SelfDrivingCar(String algorithmVersion, String company) {
        super(algorithmVersion, "");
        this.algorithmVersion = algorithmVersion;
        this.company = company;
    }

    private String getAlgorithmVersion() {
        return algorithmVersion;
    }

    void setAlgorithmVersion(String algorithmVersion) {
        this.algorithmVersion = algorithmVersion;
    }

    @Override
    public Driver copy() {
        return new SelfDrivingCar(algorithmVersion, company);
    }

    @Override
    public String getName() {
        return "Self Driving Car - " + this.company + " (" + this.getAlgorithmVersion() + ")";
    }

}
