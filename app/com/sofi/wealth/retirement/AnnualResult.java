package com.sofi.wealth.retirement;

import java.util.Objects;

public class AnnualResult implements Comparable<AnnualResult> {

    private Integer year;
    private double startingBalance;
    private double endingBalance;
    
    public AnnualResult(int year, double startingBalance, double endingBalance) {
        super();
        this.year = year;
        this.startingBalance = startingBalance;
        this.endingBalance = endingBalance;
    }
    
    public Integer getYear() {
        return year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }
    
    public double getStartingBalance() {
        return startingBalance;
    }
    
    public void setStartingBalance(double startingBalance) {
        this.startingBalance = startingBalance;
    }
    
    public double getEndingBalance() {
        return endingBalance;
    }
    
    public void setEndingBalance(double endingBalance) {
        this.endingBalance = endingBalance;
    }
    
    @Override
    public int compareTo(AnnualResult other) {
        return this.year.compareTo(other.getYear());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(year);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnualResult)) {
            return false;
        }
        AnnualResult other = (AnnualResult)obj;
        return Objects.equals(year, other.year);
    }
    
}
