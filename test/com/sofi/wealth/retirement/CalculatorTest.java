package com.sofi.wealth.retirement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.sofi.wealth.retirement.Calculator;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class CalculatorTest {

    @Test
    public void testNoExpensesNoMonthly() {
        // Given
//        public Calculator(int numberOfYears, double frontLoad, double annualExpenseRatio, double startingBalance,
//                          double monthlyContribution) {
        Double startingBalance = 10000.0d;
        Double anticipatedEndingBalance = null;
        Calculator c = new Calculator(3, 0.0d, 0.00d, startingBalance, 0.0d);
        
        // When
        List<AnnualResult> results = c.getResults();
        
        // Then
        Iterator<AnnualResult> iterator = results.iterator();
        AnnualResult firstYearResult = iterator.next();
        assertEquals(new Integer(2017), firstYearResult.getYear());
        assertEquals(startingBalance, firstYearResult.getStartingBalance());
        anticipatedEndingBalance = new Double(10800);
        assertEquals(anticipatedEndingBalance, firstYearResult.getEndingBalance());
        
        startingBalance = anticipatedEndingBalance; // set to ending balance from last year
        AnnualResult secondYearResult = iterator.next();
        assertEquals(new Integer(2018), secondYearResult.getYear());
        assertEquals(startingBalance, secondYearResult.getStartingBalance());
        anticipatedEndingBalance = new Double(11664);
        assertEquals(anticipatedEndingBalance, secondYearResult.getEndingBalance());
        
        startingBalance = anticipatedEndingBalance; // set to ending balance from last year
        AnnualResult thirdYearResult = iterator.next();
        assertEquals(new Integer(2019), thirdYearResult.getYear());
        assertEquals(startingBalance, thirdYearResult.getStartingBalance());
        anticipatedEndingBalance = new Double(12597.12);
        assertEquals(anticipatedEndingBalance, thirdYearResult.getEndingBalance());
        
        assertTrue(results.size() == 3);
    }
    
    @Test
    public void testWithExpensesButNoLoadAndNoMonthly() {
        // Given
        Double startingBalance = 10000.0d;
        Double anticipatedEndingBalance = null;
        Calculator c = new Calculator(3, 0.0d, 0.01d, startingBalance, 0.0d);
        
        // When
        List<AnnualResult> results = c.getResults();
        
        // Then
        Iterator<AnnualResult> iterator = results.iterator();
        AnnualResult firstYearResult = iterator.next();
        assertEquals(startingBalance, firstYearResult.getStartingBalance());
        anticipatedEndingBalance = new Double(10692);
        assertEquals(anticipatedEndingBalance, firstYearResult.getEndingBalance());
        
        startingBalance = anticipatedEndingBalance; // set to ending balance from last year
        AnnualResult secondYearResult = iterator.next();
        assertEquals(startingBalance, secondYearResult.getStartingBalance());
        anticipatedEndingBalance = new Double(11431.89);
        assertEquals(anticipatedEndingBalance, secondYearResult.getEndingBalance());
        
        startingBalance = anticipatedEndingBalance; // set to ending balance from last year
        AnnualResult thirdYearResult = iterator.next();
        assertEquals(startingBalance, thirdYearResult.getStartingBalance());
        anticipatedEndingBalance = new Double(12222.98);
        assertEquals(anticipatedEndingBalance, thirdYearResult.getEndingBalance());
    }
    
    @Test
    public void testWithExpensesAndLoadButNoMonthly() {
        // Given
        Double startingBalance = 10000.0d;
        Double anticipatedEndingBalance = null;
        Calculator c = new Calculator(3, 0.01d, 0.01d, startingBalance, 0.0d);
        
        // When
        List<AnnualResult> results = c.getResults();
        
        // Then
        Iterator<AnnualResult> iterator = results.iterator();
        AnnualResult firstYearResult = iterator.next();
        assertEquals(startingBalance, firstYearResult.getStartingBalance());
        anticipatedEndingBalance = new Double(10585.08);
        assertEquals(anticipatedEndingBalance, firstYearResult.getEndingBalance());
        
        startingBalance = anticipatedEndingBalance; 
        AnnualResult secondYearResult = iterator.next();
        assertEquals(startingBalance, secondYearResult.getStartingBalance());
        anticipatedEndingBalance = new Double(11317.57);
        assertEquals(anticipatedEndingBalance, secondYearResult.getEndingBalance());
        
        startingBalance = anticipatedEndingBalance; 
        AnnualResult thirdYearResult = iterator.next();
        assertEquals(startingBalance, thirdYearResult.getStartingBalance());
        anticipatedEndingBalance = new Double(12100.75);
        assertEquals(anticipatedEndingBalance, thirdYearResult.getEndingBalance());
    }
    
    @Test
    public void testWithExpensesAndLoadAndMonthly() {
        // Given
        Double startingBalance = 10000.0d;
        Double anticipatedEndingBalance = null;
        Calculator c = new Calculator(3, 0.01d, 0.01d, startingBalance, 500.0d);
        
        // When
        List<AnnualResult> results = c.getResults();
        
        // Then
        Iterator<AnnualResult> iterator = results.iterator();
        AnnualResult firstYearResult = iterator.next();
        assertEquals(startingBalance, firstYearResult.getStartingBalance());
        anticipatedEndingBalance = new Double(16525.08);
        assertEquals(anticipatedEndingBalance, firstYearResult.getEndingBalance());
        
        startingBalance = anticipatedEndingBalance; 
        AnnualResult secondYearResult = iterator.next();
        assertEquals(startingBalance, secondYearResult.getStartingBalance());
        anticipatedEndingBalance = new Double(23608.62);
        assertEquals(anticipatedEndingBalance, secondYearResult.getEndingBalance());
        
        startingBalance = anticipatedEndingBalance; 
        AnnualResult thirdYearResult = iterator.next();
        assertEquals(startingBalance, thirdYearResult.getStartingBalance());
        anticipatedEndingBalance = new Double(31182.34);
        assertEquals(anticipatedEndingBalance, thirdYearResult.getEndingBalance());
    }
    
}
