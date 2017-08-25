package com.sofi.wealth.retirement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.sofi.wealth.retirement.BigUtil.*;

public class Calculator {

    // Constants
    public static final int STARTING_YEAR = LocalDate.now().getYear();
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

        // Build up the subsequent AnnualResult objects
        BigDecimal currentBalance = roundMoney(startingBalance.multiply(BigDecimal.ONE.subtract(frontLoad)));
        for (int year = STARTING_YEAR; year < endingYear; year++) {
            final BigDecimal balanceAfterAnnualReturn = roundCalc(currentBalance.multiply(BigDecimal.ONE.add(ASSUMED_MARKET_RETURN)));
            final BigDecimal balanceAfterAnnualReturnMinusExpenseRatio = roundMoney(balanceAfterAnnualReturn.multiply(BigDecimal.ONE.subtract(annualExpenseRatio)));
            final BigDecimal balanceAfterReturnMinusExpensePlusContribution = balanceAfterAnnualReturnMinusExpenseRatio.add(annualContributionAfterLoad);
            AnnualResult result = null;
            if (year == STARTING_YEAR) {
                result = new AnnualResult(year, startingBalance.doubleValue(), balanceAfterReturnMinusExpensePlusContribution.doubleValue());
            } else {
                result = new AnnualResult(year, currentBalance.doubleValue(), balanceAfterReturnMinusExpensePlusContribution.doubleValue());
            }
            results.add(result);
            // Set the currentBalance to the year's end balance.
            currentBalance = balanceAfterReturnMinusExpensePlusContribution;
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
