package org.example.View;


import org.example.Exception.BudgetTrackerException;
import org.example.Exception.CLIException;
import org.example.Model.budgetTracker;
import org.example.Service.BudgetTrackerService;

import java.util.List;
import java.util.Scanner;

/**
 * Used to parse responses to prompts for budget data
 */
public class CLIParser {

//    constructor
    BudgetTrackerService budgetTrackerService;
    public CLIParser(){
        budgetTrackerService = new BudgetTrackerService();
    }

    public String parseCommandReturnOutput(String command) throws CLIException, BudgetTrackerException {
        if (command.equals("add")) {
            return interpretAddAction();
        } else if (command.equals("view")) {
            return interpretViewAction();
        } else {
            throw new CLIException("Valid options are add/view.  Try again...");
        }
    }

    public String interpretAddAction() throws BudgetTrackerException {
        Scanner sc = new Scanner(System.in);
        System.out.println("input Budget Entry Type (I/E):");
        String budgetEntryTypeInput = sc.nextLine();
        System.out.println("input description:");
        String budgetEntryDescriptionInput = sc.nextLine();
        System.out.println("input amount");
        String budgetEntryAmountInputString = sc.nextLine();
        double budgetEntryAmount = Double.parseDouble(budgetEntryAmountInputString);

        budgetTrackerService.addBudgetTracker(budgetEntryTypeInput, budgetEntryDescriptionInput, budgetEntryAmount);

        return "Budget Entry Added";
    }

    public String interpretViewAction() throws BudgetTrackerException {
//        List<budgetTracker> budgetEntriesList = new budgetTrackerService.getBudgetTrackerList().toString();
        List<budgetTracker> budgetEntriesList = budgetTrackerService.getBudgetTrackerList();

        return budgetEntriesList.toString();
    }
}
