package org.example.Service;

import org.example.Exception.BudgetTrackerException;
import org.example.Main;
import org.example.Model.budgetSummary;
import org.example.Model.budgetTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;

public class BudgetTrackerService {

    public static Logger log = LoggerFactory.getLogger(Main.class);

    List<budgetTracker> budgetTrackerList;
    List<budgetSummary> budgetSummaryList;

    public BudgetTrackerService(){
        budgetTrackerList = new ArrayList<>();
        budgetSummaryList = new ArrayList<>();
    }

    public void addBudgetTracker(String entryType , String description, double amount) throws BudgetTrackerException {
//        Test for data entry errors I want to track.  Adding other tests as part of first if since once we find a problem
//        there is no need to check any further

//        Entry Type is only I or E
        if (!(entryType.equals("I") || entryType.equals("E"))){
            log.warn("Incorrect Entry Type:  " + entryType);
            throw new BudgetTrackerException("Enter valid Entry Type (I/E) ...");
        }
//        Check that the description has a value, although I don't care about the contents
        else if ((description.isEmpty())) {
            log.warn("Empty description entered");
            throw new BudgetTrackerException("Enter a description of the budget item ...");
        }
//        Check if the amount is less than 0
        else if (amount < 0) {
            log.warn("Amount less than 0 entered:  " + amount);
            throw new BudgetTrackerException("Amount cannot be negative ...");
        }
//        Check if the amount is > 10,000
        else if (amount > 10000) {
            log.warn("Amount greater than 10,000 entered:  " + amount);
            throw new BudgetTrackerException("Amount cannot be greater than 10,000.00 ...");
        }
//        We passed all business rules validations, add the new record
        budgetTracker bt = new budgetTracker(entryType, description, amount);
        budgetTrackerList.add(bt);
    }

    public List<budgetTracker> getBudgetTrackerList() throws BudgetTrackerException{
//        If there is an empty list, indicate something should be added before viewing
        if (budgetTrackerList.isEmpty()){
            log.info("Tried to view before having any entries.");
            throw new BudgetTrackerException("Nothing to view, add an entry before viewing...");
        }
        return budgetTrackerList;
    }

    public List<budgetSummary> getBudgetSummaryList() throws BudgetTrackerException{
//        If there is an empty list, indicate something should be added before viewing
        budgetSummary bs;

        if (budgetTrackerList.isEmpty()){
            log.info("Tried to view summary before having any entries.");
            throw new BudgetTrackerException("Nothing to view, add an entry before viewing the summary...");
        }
        else {

            double incomeAmount = 0.0;
            double expenseAmount = 0.0;
            double netAmount = 0.0;
            log.debug("Budget Summary for non-empty Tracker list.");
            for (int i = 0; i < budgetTrackerList.size(); i++ ) {
                if (budgetTrackerList.get(i).getEntryType().equals("I")) {
                    incomeAmount = incomeAmount + budgetTrackerList.get(i).getAmount();
                }
                else {
                    expenseAmount = expenseAmount + budgetTrackerList.get(i).getAmount();
                }
            }
            netAmount = incomeAmount - expenseAmount;
            log.debug("incomeAmount:  "+incomeAmount);
            log.debug("expenseAmount:  "+expenseAmount);
            log.debug("netAmount:  "+netAmount);
            bs = new budgetSummary(incomeAmount, expenseAmount, netAmount);
            log.debug("New budget Summary:  "+ bs);
//            Clear the list, since this should contain only the new entry
            budgetSummaryList.clear();
//            load the budgetSummary entity
            budgetSummaryList.add(bs);
        }
    return budgetSummaryList;

    }

    public List<budgetTracker> getBudgetTrackerSearchList(String searchWord) throws BudgetTrackerException{
//        If there is an empty source list, indicate something should be added before viewing
        if (budgetTrackerList.isEmpty()){
            log.info("Tried to search before having any entries.");
            throw new BudgetTrackerException("Nothing to view, add an entry before viewing...");
        }
        // create a new budgetTrackerList to hold the results of the search

        List<budgetTracker> budgetTrackerSearchResultsList = new ArrayList<>();

        // loop through the budget tracker list and determine indexes that have matching value in the description field.
        // return the values in that list

        for (int i = 0; i < budgetTrackerList.size(); i++) {
            if (budgetTrackerList.get(i).getDescription().equals(searchWord)) {
                budgetTrackerSearchResultsList.add(budgetTrackerList.get(i));
            }
        }

        return budgetTrackerSearchResultsList;
    }

}
