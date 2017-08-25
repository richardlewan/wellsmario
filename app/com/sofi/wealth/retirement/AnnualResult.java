package com.sofi.wealth.retirement;

import java.util.Objects;

public class AnnualResult implements Comparable<AnnualResult> {

    private Integer year;
    private Double startingBalance;
    private Double endingBalance;
    
    public AnnualResult(int year, Double startingBalance, Double endingBalance) {
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
    
    public Double getStartingBalance() {
        return startingBalance;
    }
    
    public void setStartingBalance(Double startingBalance) {
        this.startingBalance = startingBalance;
    }
    
    public Double getEndingBalance() {
        return endingBalance;
    }
    
    public void setEndingBalance(Double endingBalance) {
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
