package models;

public class InputForm {
    private int years;
    private double savings;
    private double monthlyAmount;

    public InputForm() {
        super();
    }
    public InputForm(int years, double savings, double monthlyAmount) {
        super();
        this.years = years;
        this.savings = savings;
        this.monthlyAmount = monthlyAmount;
    }
    public int getYears() {
        return years;
    }
    public void setYears(int years) {
        this.years = years;
    }
    public double getSavings() {
        return savings;
    }
    public void setSavings(double savings) {
        this.savings = savings;
    }
    public double getMonthlyAmount() {
        return monthlyAmount;
    }
    public void setMonthlyAmount(double monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }


}
