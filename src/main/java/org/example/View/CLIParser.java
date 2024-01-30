package org.example.View;


import org.example.Exception.BudgetTrackerException;
import org.example.Exception.CLIException;
import org.example.Main;
import org.example.Model.budgetSummary;
import org.example.Model.budgetTracker;
import org.example.Service.BudgetTrackerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

/**
 * Used to parse responses to prompts for budget data
 */
public class CLIParser {

    //    constructor
    BudgetTrackerService budgetTrackerService;

    public static Logger log = LoggerFactory.getLogger(Main.class);

    public CLIParser() {
        budgetTrackerService = new BudgetTrackerService();
    }

    public String parseCommandReturnOutput(String command) throws CLIException, BudgetTrackerException {
        if (command.equals("add")) {
            return interpretAddAction();
        } else if (command.equals("view")) {
            return interpretViewAction();
        } else if (command.equals("summary")) {
            return interpretSummaryAction();
        } else if (command.equals("delete")) {
            return interpretDeleteAction();
        } else if (command.equals("search")) {
            return interpretSearchAction();
        } else if (command.equals("quit")) {
            return interpretQuitAction();
        } else {
            throw new CLIException("Valid options are add/view/summary.  Try again...");
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

    public String interpretSummaryAction() throws BudgetTrackerException {
//        List<budgetTracker> budgetEntriesList = new budgetTrackerService.getBudgetTrackerList().toString();
        List<budgetSummary> budgetSummaryList = budgetTrackerService.getBudgetSummaryList();


        return budgetSummaryList.toString();
    }

    public String interpretDeleteAction() {
        // List the entries with an ID to select the index to delete

        // Create scanner to process the selected index

        return "pending implementation";
    }

    public String interpretQuitAction() {
        return "pending implementation";
    }

    public String menuSearch() throws CLIException {
        // First, create a new scanner to ask for the search term

        Scanner scSearch = new Scanner(System.in);
        System.out.println("enter word for search of description");
        String input = scSearch.nextLine();

        if (input.isEmpty()) {
            // throw CLI Exception and return to previous menu
            log.info("Empty search term entered");
            throw new CLIException("no search term entered");
        }

        return input;
    }

    public String interpretSearchAction() throws BudgetTrackerException {

        //  call the search menu

        String searchWord = "";

        try {
            searchWord = menuSearch();

        } catch (CLIException exception) {
            log.warn("Problem with Search menu");
            System.out.println("Problem with Search menu:  " + exception.getMessage());

        }

//        Call the getSearResultsList
        return budgetTrackerService.getBudgetTrackerSearchList(searchWord).toString();

    }

}
