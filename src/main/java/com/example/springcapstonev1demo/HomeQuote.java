package com.example.springcapstonev1demo;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Quote for a Home by Taylor's Insurance
 */
public class HomeQuote extends Quote {
    private Home home;
    private int homeQuoteID;

    /**
     * Home quote constructor
     * @param startDate LocalDate
     * @param endDate LocalDate
     * @param premium BigDecimal
     * @param home Home
     * @param homePolicyID int
     */
    public HomeQuote(LocalDate startDate, LocalDate endDate, BigDecimal premium, Home home, int homePolicyID) {
        super(startDate, endDate, premium);
        this.home = home;
        this.homeQuoteID = homePolicyID;
    }

    public Home getHome() {
        return home;
    }
}
