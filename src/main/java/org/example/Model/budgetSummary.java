package org.example.Model;

public class budgetSummary
{
    private double incomeAmount;
    private double expenseAmount;
    private double netAmount;

    public budgetSummary(double incomeAmount, double expenseAmount, double netAmount){
        this.incomeAmount = incomeAmount;
        this.expenseAmount = expenseAmount;
        this.netAmount = netAmount;
    }

    public double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    @Override
    public String toString() {
        return "budgetSummary{" +
                "incomeAmount=" + incomeAmount +
                ", expenseAmount=" + expenseAmount +
                ", netAmount=" + netAmount +
                '}';
    }
}
