package com.example.springcapstonev1demo;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The quote class for Taylor's Insurance. Should extend home and auto quotes
 *
 * @author Daniel Kelly
 */
public abstract class Quote {
    //TODO Builder Pattern
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal premium;

    //TODO Should We Remove This? Builder Pattern thing?
    public Quote(LocalDate startDate, LocalDate endDate, BigDecimal premium) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.premium = premium;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public BigDecimal getPremium() {
        return premium;
    }
}
