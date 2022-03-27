package com.example.springcapstonev1demo;

import java.time.LocalDate;

/**
 * @author Daniel Kelly
 * Policy object for Taylor's Insurance
 */
public abstract class Policy {

    private Customer policyholder;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean status = true;

    public Policy(Customer policyholder, LocalDate startDate, LocalDate endDate) {
        this.policyholder = policyholder;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Getter for the policyholder
     * @return Customer
     */
    public Customer getPolicyholder() {
        return policyholder;
    }

    /**
     * Setter for the policyholder
     * @param policyholder
     */
    public void setPolicyholder(Customer policyholder) {
        this.policyholder = policyholder;
    }

    /**
     * Getter for Start Date of Policy
     * @return LocalDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Setter for Start Date of a Policy
     * @param startDate
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Getter for the End Date of a Policy
     * @return
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Setter for the End Date of a Policy
     * @param endDate LocalDate
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Function that checks if the end date of a policy has [assed
     * @return
     */
    public boolean isActive(){
        if(this.endDate == LocalDate.now()){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Creates premium for the policy
     * @return Double
     */
    public abstract double premium();
}
