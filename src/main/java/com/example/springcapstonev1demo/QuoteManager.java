package com.example.springcapstonev1demo;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Class that Generates Quotes for Taylor's insurance
 * @author Daniel Kelly
 */
public class QuoteManager {

    //TODO Is this Strict to the Builder Pattern for Quotes? Rename Builder?

    public static HomeQuote getNewQuoteForHome(Home home, int homePolicyID){
        return new HomeQuote(LocalDate.now(),LocalDate.now().plusDays(30),getHomeQuotePremium(home),home,homePolicyID);
    }

//    public static AutoQuote getNewAutoQuote(Auto auto, int autoQuoteID){
//        return new AutoQuote(LocalDate.now(),LocalDate.now().plusDays(30),getAutoQuotePremium(auto),auto,autoQuoteID);
//    }

    /**
     * Method to get a Quote Premium for a home.
     * @param home Home
     * @return BigDecimal Premium after tax
     */
    private static BigDecimal getHomeQuotePremium(Home home){
        InsuranceRates insuranceRates = new HardCodeRates();

        BigDecimal homePremium = new BigDecimal(insuranceRates.getBasePremiumHome());
        homePremium = homePremium.multiply(BigDecimal.valueOf(insuranceRates.getHeatingTypeFactor(home.getHeatingType())));
        homePremium = homePremium.multiply(BigDecimal.valueOf(insuranceRates.getLocationFactor(home.getLocation())));
        homePremium = homePremium.multiply(BigDecimal.valueOf(insuranceRates.homeAgeFactor(home.homeGetAge())));
        homePremium = homePremium.multiply(BigDecimal.valueOf(insuranceRates.getHomeValueFactor(home.getValue())));
        homePremium = homePremium.multiply(BigDecimal.valueOf(insuranceRates.tax()));

        return homePremium;
    }

//    /**
//     * Method to get a Quote Premium for a home.
//     * @param auto Vehicle
//     * @return BigDecimal Premium after tax
//     */
//    private static BigDecimal getAutoQuotePremium(Auto auto){
//        InsuranceRates insuranceRates = new HardCodeRates();
//
//        BigDecimal autoPremium = new BigDecimal(insuranceRates.getBasePremiumAuto());
//        autoPremium = autoPremium.multiply(BigDecimal.valueOf(insuranceRates.getDriverAgeFactor(auto.getCustomer().getDriverAge())));
//        autoPremium = autoPremium.multiply(BigDecimal.valueOf(insuranceRates.getNumberOfAccidentsFactor(auto.getNumberOfAccidents())));
//        autoPremium = autoPremium.multiply(BigDecimal.valueOf(insuranceRates.vehicleAgeFactor(auto.getVehicleYear())));
//        autoPremium = autoPremium.multiply(BigDecimal.valueOf(insuranceRates.tax()));
//        return autoPremium;
//    }
}
