package com.example.springcapstonev1demo;

import java.time.LocalDate;

public class HomePolicy extends Policy {
    private int homePolicyID;
    private Home home;

    public HomePolicy(Customer policyholder, LocalDate startDate, LocalDate endDate, Home home, int homePolicyID) {
        super(policyholder, startDate, endDate);
        this.home = home;
        this.homePolicyID = homePolicyID;
    }

    /**
     * Getter for home
     * @return Home
     */
    public Home getHome() {
        return home;
    }

    @Override
    public double premium() {
        return 0;
    }
}
