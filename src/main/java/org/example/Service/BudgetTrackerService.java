package org.example.Service;

import org.example.Exception.BudgetTrackerException;
import org.example.Model.budgetTracker;

import java.util.List;
import java.util.ArrayList;

public class BudgetTrackerService {

    List<budgetTracker> budgetTrackerList;

    public BudgetTrackerService(){
        budgetTrackerList = new ArrayList<>();
    }

    public void addBudgetTracker(String entryType , String description, double amount) throws BudgetTrackerException {
//        Test for data entry errors I want to track.  Adding other tests as part of first if since once we find a problem
//        there is no need to check any further

//        Entry Type is only I or E
        if (!(entryType.equals("I") || entryType.equals("E"))){
            throw new BudgetTrackerException("Enter valid Entry Type (I/E) ...");
        }
//        Check that the description has a value, although I don't care about the contents
        else if ((description.isEmpty())) {
            throw new BudgetTrackerException("Enter a description of the budget item ...");
        }
//        Check if the amount is less than 0
        else if (amount < 0) {
            throw new BudgetTrackerException("Amount cannot be negative ...");
        }
//        Check if the amount is > 10,000
        else if (amount > 10000) {
            throw new BudgetTrackerException("Amount cannot be greater than 10,000.00 ...");
        }
//        We passed all business rules validations, add the new record
        budgetTracker bt = new budgetTracker(entryType, description, amount);
        budgetTrackerList.add(bt);
    }

    public List<budgetTracker> getBudgetTrackerList() throws BudgetTrackerException{
//        If there is an empty list, indicate something should be added before viewing
        if (budgetTrackerList.isEmpty()){
            throw new BudgetTrackerException("Nothing to view, add an entry before viewing...");
        }
        return budgetTrackerList;
    }

}
