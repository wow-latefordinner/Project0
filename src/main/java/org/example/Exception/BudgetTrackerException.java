package org.example.Exception;

/**
 * Exception thrown when a budget Tracker entry has an invalid attribute assigned.
 */
public class BudgetTrackerException extends Exception {
    public BudgetTrackerException(String message){
        super(message);
    }
}
