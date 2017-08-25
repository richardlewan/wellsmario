package com.sofi.wealth.retirement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.sofi.wealth.retirement.BigUtil.*;

public abstract class Calculator {

    // Constants
    private static final int STARTING_YEAR = LocalDate.now().getYear();
    private static final BigDecimal ASSUMED_MARKET_RETURN = BigDecimal.valueOf(0.08); // 8% long term average
    
    final private int endingYear;
    final private BigDecimal frontLoad;
    final private BigDecimal annualExpenseRatio;
    final private BigDecimal startingBalance;
    final private BigDecimal monthlyContribution;
    
    private BigDecimal returnAfterExpenses;
    private BigDecimal annualContributionBeforeLoad;
    private BigDecimal annualContributionAfterLoad;
    
    private List<AnnualResult> results = new LinkedList<>();

    public Calculator(int numberOfYears, double frontLoad, double annualExpenseRatio, double startingBalance,
                      double monthlyContribution) {
        super();
        this.endingYear = STARTING_YEAR + numberOfYears;
        this.frontLoad = BigDecimal.valueOf(frontLoad);
        this.annualExpenseRatio = BigDecimal.valueOf(annualExpenseRatio);
        this.startingBalance = BigDecimal.valueOf(startingBalance);
        this.monthlyContribution = BigDecimal.valueOf(monthlyContribution);
        
        calculateResults();
    }
    
    private void calculateResults() {
        // Calculate things needed to calculate other things
        annualContributionBeforeLoad = roundCalc(monthlyContribution.multiply(BigDecimal.valueOf(12)));
        if (isZero(frontLoad)) {
            annualContributionAfterLoad = annualContributionBeforeLoad;
        } else {
            annualContributionAfterLoad = roundMoney(annualContributionBeforeLoad.multiply(BigDecimal.ONE.subtract(this.frontLoad)));
        }
        returnAfterExpenses = ASSUMED_MARKET_RETURN.subtract(annualExpenseRatio);
        
        // Build up the subsequent AnnualResult objects
        BigDecimal currentBalance = startingBalance;
        for (int year = STARTING_YEAR; year < endingYear; year++) {
            final BigDecimal principalAmount = currentBalance.add(annualContributionAfterLoad);
            final BigDecimal balanceAfterAnnualReturn = roundMoney(principalAmount.multiply(BigDecimal.ONE.add(returnAfterExpenses)));
            AnnualResult result = new AnnualResult(year, currentBalance.doubleValue(), balanceAfterAnnualReturn.doubleValue());
            results.add(result);
        }
    }

    public List<AnnualResult> getResults() {
        Collections.sort(results);
        return results;
    }

    public BigDecimal getAnnualContributionBeforeLoad() {
        return annualContributionBeforeLoad;
    }

    public BigDecimal getAnnualContributionAfterLoad() {
        return annualContributionAfterLoad;
    }
    
}
