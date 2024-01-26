package org.example.Model;

public class budgetTracker {
    private String entryType;
    private String description;
    private double amount;

//    create the constructor
    public budgetTracker(String entryType, String description, double amount){
        this.entryType = entryType;
        this.description = description;
        this.amount = amount;
    }

    public budgetTracker(String entryType, String description){
        this.entryType = entryType;
        this.description = description;
        this.amount = 100.00;
    }

//    create the methods to retrieve the attributes
    public String getEntryType(){
        return entryType;
    }

    public String getDescription(){
        return description;
    }

    public double getAmount(){
        return amount;
    }

//    create the methods to set the attributes


    public void setEntryType(String entryType){
        this.entryType = entryType;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

//    Create the required Object overrides


    @Override
    public String toString() {
        return "budgetTracker{" +
                "entryType='" + entryType + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
